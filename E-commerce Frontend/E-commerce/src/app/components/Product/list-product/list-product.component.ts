import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/Model/Product';
import { ServiceProductService } from 'src/app/service/service-product.service';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {

  constructor(private service:ServiceProductService, private router:Router) { }

  public listado:any=[];
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

}
