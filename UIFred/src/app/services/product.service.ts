import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { url } from '../common/Path';
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = url +'/product';

  constructor(private httpClient: HttpClient) { }
//get all products
  getProduct(): Observable<any> {
    return this.httpClient.get<GetResponse>(this.baseUrl+'/all')
  }
  //get by id
  getProductId(id:number): Observable<any> {
    return this.httpClient.get<GetResponse>(this.baseUrl+'/id/'+id)
    //.pipe(map(response => response._product.product)
    //);
  }
  //get by
  getProductName(name:string): Observable<any> {
    return this.httpClient.get<GetResponse>(this.baseUrl+'/name/'+name)
    //.pipe(  map(response => response._product.product)
    //);
  }
}


interface GetResponse {
  _product: any;
  product: Product[];
    
  }
