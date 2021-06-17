import { error } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {


products:Product[]=[];
load:boolean=false;
  constructor(private router:Router, private service:ServiceProductService, private activatedrouter:ActivatedRoute) { }

  ngOnInit(): void {
    this.Product()
  }


  back(){
    this.router.navigate(['homeuser'])
  }

  Product(){
    this.activatedrouter.params.subscribe(
      e=>{
        let identificationNumber=e['id'];
        if(identificationNumber){
          this.service.getProductId(identificationNumber).subscribe(data=>{
            this.products=data.products;
            this.load = true;
          }), (error:any)=>{ console.log(error)};
        }
      }
    )
  }


  edit(product:Product){
    this.service.updateProduct(product).subscribe(()=>{
      alert("Actualizado con exito")
      this.editlocal(product);
      this.router.navigate(['homeuser']);
    })
  }


  editlocal(product:Product){
    let temp: Product[] = []
    temp = JSON.parse(localStorage.getItem('home') || '{}')
    for(var i=0; i<temp.length; i++){      
      if(product.identificationNumber == (temp[i]['identificationNumber'])){
        var aux = JSON.parse(localStorage.getItem('home') || '{}');
        aux.splice(i,1);
        localStorage.setItem('home', JSON.stringify(aux))
        temp[i].name = product.name
        temp[i].description = product.description
        temp[i].base_Price = product.base_Price
        temp[i].tax_Rate = product.tax_Rate
        temp[i].productstatus = product.productstatus
        temp[i].inventory = product.inventory
        localStorage.setItem('home', JSON.stringify(temp))
      }
    }
  }
}