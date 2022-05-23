// import { Component, Input, OnInit } from '@angular/core';
// import { RegistrationService } from 'src/app/services/registration/registration.service';

// @Component({
//   selector: 'app-registration',
//   templateUrl: './registration.component.html',
//   styleUrls: ['./registration.component.css']
// })
// export class RegistrationComponent implements OnInit {

//   constructor(private registrationService: RegistrationService) { }

//   ngOnInit(): void {

//   }
//   username : string = ""
//   password : string = ""
//   firstName : string = ""
//   lastName : string = ""
//   email : string = ""

//   result : string = "";

//   register(username: string, password: string, fistName: string, lastName: string, email: string){
//     let user: User = new User(this.username,this.password,this.firstName,this.lastName, this.email);
//     this.registrationService.register(user).subscribe((data: any) => this.result = "User Added")
//   }

// }

// export class User {
//   username: string = ""
//   password: string = ""
//   firstName: string = ""
//   lastName: string = ""
//   email: string = ""

//   constructor(_username : string, _password : string, _firstName : string, _lastName: string, _email: string){
//     this.username = _username;
//     this.password = _password;
//     this.firstName = _firstName;
//     this.lastName = _lastName;
//     this.email = _email;
//   }
// }
