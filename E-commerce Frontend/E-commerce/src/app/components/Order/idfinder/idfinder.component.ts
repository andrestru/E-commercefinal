import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ServiceOrderService } from 'src/app/service/service-order.service';
import { Validate } from '../../Product/Validate';

@Component({
  selector: 'app-idfinder',
  templateUrl: './idfinder.component.html',
  styleUrls: ['./idfinder.component.css']
})
export class IdfinderComponent implements OnInit {

  identification:number=0
  public searchid!:FormGroup

  constructor(private service:ServiceOrderService, private router:Router) { }

  ngOnInit(): void {
    this.searchid = this.createForm()
  }

  createForm(){
    return new FormGroup({
      identification: new FormControl('', Validators.compose([Validate.Idnumber]))
    })
  }


}
