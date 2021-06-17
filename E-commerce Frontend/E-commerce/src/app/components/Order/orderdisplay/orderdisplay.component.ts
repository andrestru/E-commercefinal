import { Component, OnInit } from '@angular/core';
import { ServiceOrderService } from 'src/app/service/service-order.service';

@Component({
  selector: 'app-orderdisplay',
  templateUrl: './orderdisplay.component.html',
  styleUrls: ['./orderdisplay.component.css']
})
export class OrderdisplayComponent implements OnInit {

  list:any=[]
  constructor(private service:ServiceOrderService) { }

  ngOnInit(): void {
    this.load()
  }

  load(){
    this.service.getOrder().subscribe((data)=>{
      this.list = data.orders
    })
  }

}
