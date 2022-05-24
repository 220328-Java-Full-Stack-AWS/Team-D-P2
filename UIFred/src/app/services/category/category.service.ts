import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders} from '@angular/common/http'
import { Observable } from 'rxjs';
import { path } from '../../common/defaultPath';


@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  
  constructor(private http: HttpClient) { }

  getCategoryData(): Observable<any>{
    
    let token = 'Bearer ' + localStorage.getItem('Authorization');
    
    let reqHeader = new HttpHeaders({ 
        'Content-Type': 'application/json',
        'Authorization' : JSON.stringify(token)
     });
    return this.http.get(path +'/category/byId/1', {headers: reqHeader});
    
  }
  getAllCategoryData(): Observable<any>{
    let token = 'Bearer ' + localStorage.getItem('Authorization');
    
    let reqHeader = new HttpHeaders({ 
        'Content-Type': 'application/json',
        'Authorization' : JSON.stringify(token)
     });
    return this.http.get(path+'/category/getAll', {headers: reqHeader});
  }

}
