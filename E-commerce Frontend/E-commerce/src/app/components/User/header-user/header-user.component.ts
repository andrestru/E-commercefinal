import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header-user',
  templateUrl: './header-user.component.html',
  styleUrls: ['./header-user.component.css']
})
export class HeaderUserComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  logout(){
    this.router.navigate(['']);
  }

  inicio(){
    this.router.navigate(['homeuser']);
  }

  order(){
    this.router.navigate(['order']);
  }

 

}
