import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Order } from 'src/app/Model/Order';
import { ServiceOrderService } from 'src/app/service/service-order.service';

@Component({
  selector: 'app-editorder',
  templateUrl: './editorder.component.html',
  styleUrls: ['./editorder.component.css']
})
export class EditorderComponent implements OnInit {

  constructor(private service:ServiceOrderService, private router:Router, private activedrouter:ActivatedRoute) { }

  ngOnInit(): void {
    this.load()
  }

  carga:boolean = false;
  listado:Order[] = [];
  load(){
    this.activedrouter.params.subscribe(
      e=>{
        let number_order = e['id'];
        if(number_order){
          this.service.getOrderId(number_order).subscribe(data=>{
            this.listado = data.orders;
            this.carga = true;
          })
        }
      }
    )
  }

  back(){
    this.router.navigate(['order'])
  }

  save(orders:Order){
    console.log(orders)
    this.service.updateOrder(orders).subscribe(()=>{
      alert("Edited order")
      this.router.navigate(['order'])
    })
  }

  


}
