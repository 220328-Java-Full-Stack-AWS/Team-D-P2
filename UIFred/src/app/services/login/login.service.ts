import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/common/User';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any>{
      let userDto: UserDto = new UserDto();
      userDto.username = username;
      userDto.password = password;
      return this.http.post("http://localhost:8080/user/login", userDto);
  }
  updateUser(user:User): Observable<any>{
    return this.http.put("http://localhost:8080/user",user);
  }

}

export class UserDto{
  username: string = ""
  password: string = ""
}
