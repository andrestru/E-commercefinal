import { Injectable, Output, EventEmitter } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Product } from '../Model/Product';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ServiceProductService {

  
  constructor(private http:HttpClient) { }

  url='http://localhost:8080/product';

  getProduct(urlget:string){
    return this.http.get<any>(urlget);
  }

  createProduct(product:Product){
    console.log(product)
    return this.http.post<Product>(this.url,product);
  }

  deleteProduct(product:Product){
    return this.http.delete(this.url+"/delete/"+product.identificationNumber);
  }

  getProductId(id:any){
    let y: Number = +id;
    return this.http.post<any>(this.url+"/listid/",y);
  }

  updateProduct(product:Product){
    return this.http.put<Product>(this.url+"/edit/",product);
  }

  updateinventory(id:number){
    return this.http.put(this.url+"/editinv/"+`${id}`,"")
  }

}
