import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';

@Component({
  selector: 'app-shopping',
  templateUrl: './shopping.component.html',
  styleUrls: ['./shopping.component.css']
})
export class ShoppingComponent implements OnInit {

  
 // shopping=Product;
  items:Array<any>=[];
  suma:Array<any>=[];
  resultado:number=0

  constructor(private service:ServiceProductService, private router:Router) { }

  ngOnInit(): void {
    this.items = JSON.parse(localStorage.getItem('product')|| '{}');    
    this.resultado = this.total();
  }

  remove(){
    if(confirm('Are you sure you want delete?')){
      localStorage.clear();
      alert('successfully removed!')
      this.router.navigate(['']);
    }
  }

  total():number{
    this.suma = JSON.parse(localStorage.getItem('product') || '{}')
    console.log(this.suma)
    var result:number=0;
    var i:number=0;
    var prom:number=0;
    if(this.suma.length>0){
      this.suma.forEach(element => {
        result += this.suma[i]['base_Price']
        i++;
      });
      return result;
    }else{
      return 0;
    }
  }

  delete(pro:Product){
    for(let i = 0; i < this.items.length; i++){
      if(pro == this.items[i]){
        this.items.splice(i, 1);
        localStorage.setItem('product', JSON.stringify(this.items))
      }
    }
    this.count(pro)
    location.reload()
  }

  count(product:Product){
    let temp: Product[] = [];
    temp = JSON.parse(localStorage.getItem('home') || '{}')
        for(var i=0; i<temp.length; i++){      
          if(product.identificationNumber == (temp[i]['identificationNumber'])){
            var aux = JSON.parse(localStorage.getItem('home') || '{}');
            aux.splice(i,1);
            localStorage.setItem('home', JSON.stringify(aux))
            temp[i].inventory = temp[i]['inventory']+1
            localStorage.setItem('home', JSON.stringify(temp))
          }
        }  
  }

  pay(){
    this.router.navigate(['idfinder']);
  }
  



}
