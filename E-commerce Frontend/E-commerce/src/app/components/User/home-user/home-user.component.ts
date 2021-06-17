import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';


@Component({
  selector: 'app-home-user',
  templateUrl: './home-user.component.html',
  styleUrls: ['./home-user.component.css']
})
export class HomeUserComponent implements OnInit {

  listado:Product[]=[];
  page:number =1;

  constructor(private service:ServiceProductService, private router:Router) { }

  ngOnInit(): void {
    this.load();
  }

  load(){
    this.service.getProduct("http://localhost:8080/product").subscribe(
      data =>{
        this.listado=data.products
      }
    )
  }

  delete(product:Product){
    
    this.service.deleteProduct(product).subscribe(data=>{
      this.listado=this.listado.filter(p=>p!==product);
      alert("Product with name: "+product.name+" removed")
      this.count(product)
    })
    
  }

  
  count(product:Product){
    let temp: Product[] = [];
    temp = JSON.parse(localStorage.getItem('home') || '{}')
        for(var i=0; i<temp.length; i++){      
          if(product.identificationNumber == (temp[i]['identificationNumber'])){
            console.log(product.identificationNumber)
            var aux = JSON.parse(localStorage.getItem('home') || '{}');
            aux.splice(i,1);
            localStorage.setItem('home', JSON.stringify(aux))
          }
        }
  }

  addProduct(){
    this.router.navigate(['newproduct']);
  }

  edit(product:Product){
   this.router.navigate(['editproduct'])
  }

}

