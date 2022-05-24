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
  token: string = ""
  
    
  login(){
      this.loginService.login(this.username,this.password).subscribe((data: any) => {this.token = data.token; test(this.token); console.log('response headers', data.headers)});
      
  }

}

function test(token: string){
  localStorage.clear();
  sessionStorage.clear();
  console.log(token);
  localStorage.setItem('Authorization',JSON.stringify(token));
}
