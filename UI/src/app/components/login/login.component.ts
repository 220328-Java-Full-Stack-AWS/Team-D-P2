import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }
  result : string = ""

  username: string = ""
  password: string = ""
  
  login(){
      this.loginService.login(this.username,this.password).subscribe((data: any) => this.result = "User Found");
  }

}