import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  List:any=[];
  List2:any=[];
  quantity:number=0;
  img:String="https://www.mxm.com.br/wp-content/uploads/2016/02/compras.jpg";
  constructor(private service:ServiceProductService, private router:Router) { }

  ngOnInit(): void {
    this.img;
    this.loadhome();

  }


  loadhome():any{
    this.service.getProduct("http://localhost:8080/product").subscribe(data=>{
      this.List=data.products
      console.log(this.List)
      if(localStorage.getItem('home')===null || localStorage.getItem('home')=='[]'){
        localStorage.setItem('home', JSON.stringify(this.List));
      }
      this.List2=JSON.parse(localStorage.getItem('home') || '{}')
      console.log(this.List2)
    })
  }

  
  add(product:Product){
    let Listp: Product[] = [];
    if(product.inventory<=0){
      alert('no product inventory')
    }else{
      if(localStorage.getItem('product')===null){
        Listp.push(product)
        localStorage.setItem('product', JSON.stringify(Listp))
        this.count(product);
      }else{
        this.count(product);
        Listp = JSON.parse(localStorage.getItem('product') || '{}')
        Listp.push(product)
        localStorage.setItem('product', JSON.stringify(Listp))
      }
      alert('added product')
      location.reload()
    }
  }

  count(product:Product){
    let temp: Product[] = [];
    temp = JSON.parse(localStorage.getItem('home') || '{}')
        for(var i=0; i<temp.length; i++){      
          if(product.identificationNumber == (temp[i]['identificationNumber'])){
            var aux = JSON.parse(localStorage.getItem('home') || '{}');
            aux.splice(i,1);
            localStorage.setItem('home', JSON.stringify(aux))
            temp[i].inventory = temp[i]['inventory']-1
            localStorage.setItem('home', JSON.stringify(temp))
          }
        }
        
  }

}
