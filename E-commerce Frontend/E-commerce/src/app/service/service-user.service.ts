import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../Model/User';

@Injectable({
  providedIn: 'root'
})
export class ServiceUserService {

  url='http://localhost:8080/user';

  constructor(private http:HttpClient) { }

  getUser(u:User){
    return this.http.post<any>(this.url+"/list/",u);
  }

  
}
