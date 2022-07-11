import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginService } from '../login.service';
import { AuthService } from '../services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  form = new FormGroup({
    username: new FormControl('', [Validators.required]),
    password: new FormControl('', [Validators.required])
  })

  constructor(private router: Router, private loginService: LoginService, private route: ActivatedRoute,
    private service: AuthService) { }

  ngOnInit() {
  }
  /* 
    login() {
      console.log("inside login()");
      this.router.navigate(['/employees']);
    } */

  check(username: string, password: string) {
    console.log("Inside check() function");
    let json = JSON.stringify({
      username: username,
      password: password
    });
    console.log(json);
    this.loginService.addUser(json)
      .subscribe(data => {
        console.log(data)
        if (data.authenticated) {
          this.service.logIn();
          this.router.navigate(['/employees']);
        }
        else {
          return false;
        }
      }
      );
  }

}
