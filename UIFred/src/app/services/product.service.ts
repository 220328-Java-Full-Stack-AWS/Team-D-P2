import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Product } from '../common/product/product';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  getCategory() {
    throw new Error('Method not implemented.');
  }

  private baseUrl = 'http://localhost:8080/api/product';


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
