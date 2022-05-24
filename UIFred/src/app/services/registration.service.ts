 import { HttpClient } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Observable } from 'rxjs/internal/Observable';
 import { User } from '../common/User';
 import { url } from '../common/Path';

 @Injectable({
   providedIn: 'root'
 })
 export class RegistrationService {

   constructor(private http: HttpClient) {}
   
   register(body: User): Observable<any>{
     console.log(url);
     console.log(body);
     return this.http.post(url +'/user', body);
   }
 }