import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/Model/User';
import { ServiceUserService } from 'src/app/service/service-user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private router:Router, private service:ServiceUserService) { }

  ngOnInit(): void {
  }

  Inicio(){
    this.router.navigate(["/"]);
  }

  Order(){
    this.router.navigate(["shopping"]);
  }

  orders(){
    this.router.navigate(['orders'])
  }


  login(){
    this.router.navigate(['login'])
  }

}
