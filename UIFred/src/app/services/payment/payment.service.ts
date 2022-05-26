import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Payment } from '../../common/Models';
import { path } from '../../common/defaultPath';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http:HttpClient) { }
  updatePayment(p:any):Observable<any>{
    console.log(p)
    return this.http.put(path+'/payments',p)
  }
}
