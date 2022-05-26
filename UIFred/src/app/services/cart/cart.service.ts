
 import { HttpClient, HttpHeaders } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Observable } from 'rxjs/internal/Observable';
 import { User } from 'src/app/common/User';
 import { url } from 'src/app/common/Path'
import { Cart } from 'src/app/common/Models';
  

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient){ }

  getCart(cartId: string): Observable<any>{

    let header = new HttpHeaders({'cartId': cartId})
    console.log("We are in service and cartId is " + cartId)
    return this.http.post(url +'/cart', {headers: header});
  }

  addProduct(cartId: any, product: any) {

    let header = new HttpHeaders({'cartId': cartId})
    return this.http.put(url +'/cart/addProduct', product, {headers: header});

  }

  deleteProduct(cartId: any, product: any) {

    let header = new HttpHeaders({'cartId': cartId})
    return this.http.put(url +'/cart/deleteProduct', product, {headers: header});

  }


}
