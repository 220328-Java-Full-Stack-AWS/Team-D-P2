import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from '../../common/Models';
import { path } from '../../common/defaultPath';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  constructor(private http: HttpClient) {}
   
  register(body: User): Observable<any>{
    return this.http.post(path +'/user/register', body);
  }
}
