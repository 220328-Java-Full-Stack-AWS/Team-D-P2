
import { Component, Input, OnInit } from '@angular/core';
import { User } from '../../common/User';
import { RegistrationService } from '../../services/registration/registration.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration-form.html',
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
  streetName : string = ""
  city : string = ""
  state : string = ""
  zipCode : string = ""
  phone : string = ""
  enabled : boolean = false
  
  result : string = "";


  register(){
    let user: User = new User(this.username,this.password,this.firstName,this.lastName,this.enabled,this.email,this.phone,this.streetName,this.city,this.state,this.zipCode);
    console.log(user);
    this.registrationService.register(user).subscribe((data: any) => console.log("user added"))
  }
}

