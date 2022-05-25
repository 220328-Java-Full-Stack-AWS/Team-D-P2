import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError, catchError, retry } from 'rxjs';
import { Payment } from '../../common/Models';


@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  // Base url
  baseurl = 'http://localhost:4200/payments';

  constructor(private http: HttpClient) {
  }

  // Http Headers
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // POST
  CreatePayment(data: any): Observable<Payment> {
    return this.http.post<Payment>(this.baseurl, JSON.stringify(data), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }

  // GET
  GetPayment(id: string): Observable<Payment> {
    return this.http.get<Payment>(this.baseurl + id)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }

  // GET
  GetPayments(): Observable<Payment> {
    return this.http.get<Payment>(this.baseurl)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }

  // PUT
  UpdatePayment(id: string, data: any): Observable<Payment> {
    return this.http.put<Payment>(this.baseurl + id, JSON.stringify(data), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }

  // DELETE
  DeleteEmployee(id: string) {
    return this.http.delete<Payment>(this.baseurl + id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHandl)
      )
  }

  // Error handling
  errorHandl(error: { error: { message: string; }; status: any; message: any; }) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(() => new Error(errorMessage));
  }
}
