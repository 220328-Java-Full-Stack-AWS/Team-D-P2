import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login-form.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  constructor(private loginService: LoginService) { }

  ngOnInit(): void {
  }
 
  username: string = ""
  password: string = ""
  errorMessageUsername = ""
  errorMessagePassword = ""

  response : User = {
    id : 0,
    username : "",
    password : ""
  }
  
    
  login(){
      this.loginService.login(this.username,this.password).subscribe((data: any) => {this.response.id = data.id,this.response.username = data.username,this.response.password = data.password; 
                                                                                    sessionStorage.setItem("id",data.id),sessionStorage.setItem("username",data.username),sessionStorage.setItem("cartId",data.cart.id),
                                                                                    sessionStorage.setItem("user",JSON.stringify(data))});
      

  }

}

export class User{
  id: number = 0;
  username: string = ""
  password: string = ""
}