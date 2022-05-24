 import { Component, Input, OnInit } from '@angular/core';
 import { RegistrationService } from 'src/app/services/registration.service';
import {User} from 'src/app/common/User';
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

   register(username: string, password: string, fistName: string, lastName: string, email: string){
     let user: User = new User();
     //this.username,this.password,this.firstName,this.lastName, this.email
     user.username=this.username;user.password=this.password;user.firstName=this.firstName;
     user.lastName=this.lastName;user.email=this.email;
     this.registrationService.register(user).subscribe((data: any) => this.result = JSON.stringify(data))
   }

 }
