import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isAuthenticated: boolean = false;
  userFullName!: string; 

  storage: Storage = sessionStorage;
  userService: any;

  constructor(private UserService: any ) { }

  ngOnInit(): void {

    // Subscribe to authentication state changes
    this.userService.$authenticationState.subscribe(
      (result: boolean) => {
        this.isAuthenticated = result;
        this.getUserDetails();
      }
    );
    
  }

  getUserDetails() {
    if (this.isAuthenticated) {

      // Fetch the logged in user details (user's claims)
      //
      // user full name is exposed as a property name
      this.userService.getUser().then(
        (res: { name: string; email: any; }) => {
          this.userFullName = res.name;

          // retrieve the user's email from authentication response
          const theEmail = res.email;

          // now store the email in browser storage
          this.storage.setItem('userEmail', JSON.stringify(theEmail));
        }
      );
    }
  }

  logout() {
    // Terminates the session with Okta and removes current tokens.
    this.userService.signOut();
  }
}
