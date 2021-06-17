import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validator, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/Model/Order';
import { ServiceOrderService } from 'src/app/service/service-order.service';
import { ServiceProductService } from 'src/app/service/service-product.service';

@Component({
  selector: 'app-final',
  templateUrl: './final.component.html',
  styleUrls: ['./final.component.css']
})
export class FinalComponent implements OnInit {

  constructor(private service:ServiceOrderService, private activerouter:ActivatedRoute, private router:Router, private servicep:ServiceProductService) { }

  public formb!: FormGroup
  suma:Array<any>=[];
  identification:number=0;
  resultado:number=0;
  discounts:number=0;
  final:number=0;


  ngOnInit(): void {
    this.load()
    this.formb = this.createform();
    this.resultado = this.total();
  }

  createform(){
    return new FormGroup({
      name: new FormControl('', Validators.required),
      address: new FormControl('', Validators.required),
      identification: new FormControl(this.identification)
    })
  }

  listado:Order[] = [];

  load(){
    let ret = 0;
    this.activerouter.params.subscribe(e=>{
     this.identification = e['id']
      if(this.identification){
        this.service.getOrderCC(this.identification).subscribe((data)=>{
          let a = (Array.from(Object.values(data))[0]).length;
          if(a>3){
            ret = this.total();
            this.discounts = ret * 0.10
            this.final = ret - this.discounts
          }else{
            this.final = this.total()
          }
        })
      }
    })
}

    total():number{
      this.suma = JSON.parse(localStorage.getItem('product') || '{}')
      var result:number=0;
      var i:number=0;
      this.suma.forEach(element => {
        result += this.suma[i]['base_Price']
        i++;
      });
      return result;
    }

    desc:Array<any>=[];
    save(){
      let order = new Order();
      let descripcion:String='';
      var i:number=0;
      var inv:number=0;
      this.desc = JSON.parse(localStorage.getItem('product') || '{}')
      this.desc.forEach(element => {
        descripcion += ' Product with id number: '+this.desc[i]['identificationNumber'] + " and name: "+this.desc[i]['name']+'; \n'
        inv = this.desc[i]['identificationNumber'];
        this.servicep.updateinventory(inv).subscribe(()=>{
        })
        i++;
      });
      order.name = `${this.formb.value.name}`
      order.address = `${this.formb.value.address}`
      order.identification = this.formb.value.identification
      order.description = ''+descripcion
      order.total = this.final
      localStorage.clear()
      this.service.saveOrder(order).subscribe(()=>{
        alert('congratulations on your purchase')
        this.router.navigate([''])
      })
    }

}
