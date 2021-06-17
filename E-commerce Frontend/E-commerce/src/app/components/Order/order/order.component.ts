import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Order } from 'src/app/Model/Order';
import { ServiceOrderService } from 'src/app/service/service-order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {

  listado:Order[]=[];
  page:number =1;

  constructor(private service:ServiceOrderService, private router:Router) { }

  ngOnInit(): void {
    this.load()
  }

  load(){
    this.service.getOrder().subscribe(data=>{
      this.listado = data.orders
    })
  }

  DeleteOrder(num_order:String){
      if(confirm("Are you sure?")){
        this.service.delete(num_order).subscribe(()=>{
          location.reload()
        })
      } 
  }

  statusorder(num_order:String){
    if(confirm("Are you sure?")){
      this.service.updatestatus(num_order).subscribe(()=>{
        alert("order approved successfully")
        location.reload()
      })
    }
  }

}
