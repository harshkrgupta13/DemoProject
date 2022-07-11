import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../User';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user:User=new User();
  
  constructor(private loginService:LoginService,private router:Router) { }

  ngOnInit() : void{
  }

  signIn(){
    console.log("inside signIn()");
    console.log(this.user);
    this.loginService.createUser(this.user).subscribe(data=>{
      console.log(data);
      this.router.navigate(['/login']);
    },
    error=>console.log(error));
  }

}
