
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../common/Models';
import { RegistrationService } from '../../services/registration/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})

export class RegistrationComponent implements OnInit {

  constructor(private registrationService: RegistrationService) { }

  ngOnInit(): void {

  }
  username : string = ""
  password : string = ""
  firstName : string = ""
  lastName : string = ""
  email : string = ""
  
  result : string = "";


  register(){
    let user: User = new User(this.username,this.password,this.firstName,this.lastName, this.email);
    this.registrationService.register(user).subscribe((data: any) => this.result = "User Added")
  }
}

