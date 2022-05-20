import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  
  constructor(private http: HttpClient) { }

  getCategoryData(): Observable<any>{
    return this.http.get('http://localhost:8080/category/byId/2');
  }
  getAllCategoryData(): Observable<any>{
    return this.http.get('http://localhost:8080/category/getAll');
  }
}
