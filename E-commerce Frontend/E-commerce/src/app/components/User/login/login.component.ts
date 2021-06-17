import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceUserService } from 'src/app/service/service-user.service';
import { User } from 'src/app/Model/User';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  email:String='';
  password:String='';
  users:Array<any>=[];

  public loginform!: FormGroup;
  
  private emailPattern: any = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;


  constructor(private router:Router, private service:ServiceUserService) { }

  createForm() {
    return new FormGroup({
      email: new FormControl('', [Validators.required, Validators.minLength(5), Validators.pattern(this.emailPattern)]),
      password: new FormControl('', [Validators.required, Validators.minLength(6)])
      });
  }
  
  ngOnInit(): void {
    this.loginform = this.createForm();
}

  login(){
    let u = new User();
    this.email=`${this.loginform.value.email}`
    this.password=`${this.loginform.value.password}`
    u.email = this.email;
    u.password = this.password
    this.service.getUser(u).subscribe(data=>{
      console.log(data);
      this.users=data.user;
      console.log(this.users);
      if(this.users.length==0){
        alert("Datos Erroneos")
       // this.loginform.reset();
      }else{
        if(this.password=this.users[0]['password']){
          alert("Bienvenido "+this.email)
          this.router.navigate(["homeuser"]);
        }else{
          alert("Datos Erroneos")
          this.loginform.reset();
        }
      }
     
    })
  }

  Index(){
    this.router.navigate(['']);
  }

}
