import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from 'src/app/components/registration/registration.component';


@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {}
   
  register(body: User): Observable<any>{
    return this.http.post('http://localhost:8080/user', body);
  }
}
