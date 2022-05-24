
 import { HttpClient, HttpHeaders } from '@angular/common/http';
 import { Injectable } from '@angular/core';
 import { Observable } from 'rxjs/internal/Observable';
 import { User } from '../common/User';
 import { url } from 'src/app/common/Path'
import { Cart } from 'src/app/common/Models';
  

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private http: HttpClient, private userService: UserService){ }

  viewCart(): Observable<any>{

    let userId = '1'

    let header = new HttpHeaders({'userId': userId})

    return this.http.get(url +'/cart/viewCart', {headers: header});
  }


}
