import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/common/User';
import { LoginService } from 'src/app/services/login/login.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private loginService:LoginService) { }

  user:any={}
  ngOnInit(): void {
    let x=sessionStorage.getItem("user")
    console.log(x)
    this.user=JSON.parse(x);
    console.log(sessionStorage.getItem("user"))
  }
  update():void{
    this.loginService.updateUer(this.user).subscribe((user:User)=>console.log(user))
  }
}
