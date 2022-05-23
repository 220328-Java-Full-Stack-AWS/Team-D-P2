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

  private baseUrl = url +'/api/product';

  constructor(private httpClient: HttpClient) { }

  getProduct(): Observable<Product[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._product.product)
    );
  }
}

interface GetResponse {
  _product: any;
  product: Product[];
    
  }
