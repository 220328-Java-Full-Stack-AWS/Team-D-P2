import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { path } from '../../common/defaultPath';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getCategoryData(): Observable<any>{
    return this.http.get(path+'/category/byId/1');
  }
  getAllCategoryData(): Observable<any>{
    return this.http.get(path+'/category/getAll');
  }
}
