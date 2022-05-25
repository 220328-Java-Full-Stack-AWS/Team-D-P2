
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

  errorMessageUsername = ""
  errorMessagePassword = ""
  errorMessageFirstName = ""
  errorMessageLastName = ""
  errorMessageEmail = ""
  errorMessageStreetName = ""
  errorMessageCity = ""
  errorMessageState =  ""
  errorMessageZipCode =  ""
  
  
  result : string = "";


  register(){
    let user: User = new User(this.username,this.password,this.firstName,this.lastName,this.enabled,this.email,this.phone,this.streetName,this.city,this.state,this.zipCode)
    this.registrationService.register(user).subscribe((data: any) => {console.log("user added");sessionStorage.setItem("user",JSON.stringify(data))},
                                                      (error) => {console.log(this.errorMessageUsername = error.error.username), 
                                                                  console.log(this.errorMessagePassword = error.error.password),
                                                                  console.log(this.errorMessageFirstName = error.error.firstName),
                                                                  console.log(this.errorMessageLastName = error.error.lastName),
                                                                  console.log(this.errorMessageEmail = error.error.enabled),
                                                                  console.log(this.errorMessageEmail = error.error.email),
                                                                  console.log(this.errorMessageStreetName = error.error.streetName),
                                                                  console.log(this.errorMessageCity = error.error.city),
                                                                  console.log(this.errorMessageState= error.error.state),
                                                                  console.log(this.errorMessageZipCode = error.error.zipCode)
                                                                })
  }
}
