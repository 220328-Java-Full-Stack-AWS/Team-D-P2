import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { url } from '../common/Path';
import { Category } from '../common/Category';
import { UrlTree } from '@angular/router';
import { Product } from '../common/Models';


@Injectable({
  providedIn: 'root'
})
export class ProductService {
  
  private baseUrl = URL +'/product';
  getCategory() {
    throw new Error('Method not implemented.');
  }


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
  //get by name
  getProductName(name:string): Observable<any> {
    return this.httpClient.get<GetResponse>(this.baseUrl+'/name')
    //.pipe(  map(response => response._product.product)
    //);

  }
  getCategoryName(name:string): Observable<any> {
    return this.httpClient.get<any>(url+'/category/byName/'+name);
  }
  getCategoryAll():Observable<any>{
    console.log("in all")
    return this.httpClient.get<any>(url+'/category/getAll');
  }
   searchProduct(theKeyword: string): Observable<Product[]> {
     console.log (theKeyword)

    // need to build URL based on the keyword 
    const searchUrl = url + `/product/search/findByNameContaining?name=${theKeyword}`
      console.log (searchUrl)
  
    return this.getSearchProduct(searchUrl)
  }
  
  getSearchProduct(searchUrl: string): Observable<any> {
  
    return this.httpClient.get<any>(searchUrl);
  }
  
  /*getProductCategories(): Observable<ProductCategory[]> {
  
    return this.httpClient.get<any>(this.searchUrl).pipe(
      map(response => response._product.productCategory)
    )
  } */
}











interface GetResponse {
  _product: any;
  product: Product[];
    
  }








