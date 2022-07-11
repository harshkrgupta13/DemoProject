import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from './User';

const httpOptions={
  headers:new HttpHeaders({'Content-Type':'application/json'})
};

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  
  url:string="http://localhost:8080/user/authenticate";
  saveUserUrl="http://localhost:8080/user";
  
  constructor(private http:HttpClient) { }

  addUser(json):Observable<any>{
    return this.http.post<any>(this.url ,json , httpOptions);
  }

  createUser(user:User):Observable<any>{
    return this.http.post(this.saveUserUrl,user);
  }
}
