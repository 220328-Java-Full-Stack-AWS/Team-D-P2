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
    //getCategoryData();
    let token = {  
      'authorization': 'Bearer ' + localStorage.getItem('Authorization')
    } //scalar value  key2: “value”, 
    
    let reqHeader = new HttpHeaders({ 
        'Content-Type': 'application/json',
        'Authorization' : JSON.stringify(token)
     });

    return this.http.get(path +'/category/byId/1', {headers: reqHeader});
  }
  getAllCategoryData(): Observable<any>{
    return this.http.get(path+'/category/getAll');
  }

}
/*
async function getCategoryData() {
  let token = localStorage.getItem('Authorization');
  const response = await fetch(
      path + '/category/byId/1',
      {
        method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization" : JSON.stringify(token)
            },
      }
    ).then(response => {
      console.log(response);
    });
  console.log(response);
}
*/