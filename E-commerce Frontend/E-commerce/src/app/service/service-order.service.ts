import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../Model/Order';

@Injectable({
  providedIn: 'root'
})
export class ServiceOrderService {

  constructor(private http:HttpClient) { }

  url = "http://localhost:8080/order";

  getOrder(){
    return this.http.get<any>(this.url);
  }

  delete(num_order:String){
    return this.http.delete(this.url+"/delete/"+num_order);
  }

  getOrderId(num_order:String){
    var json = JSON.parse(`{"number_order": "${num_order}"}`)
    return this.http.post<any>(this.url+"/listorder/",json);
  }

  updateOrder(order:Order){
    return this.http.put(this.url+"/editorder",order);
  }

  updatestatus(num_order:String){
    return this.http.put(this.url+"/status/"+`${num_order}`,"");
  }

  getOrderCC(identification:number){
    let y:number=+identification
    return this.http.post(this.url+"/listid/",y);
  }

  saveOrder(order:Order){
    return this.http.post(this.url,order)
  }

}
