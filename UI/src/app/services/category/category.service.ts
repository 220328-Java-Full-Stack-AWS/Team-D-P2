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
    getCategoryData();
    let token: any = localStorage.getItem('Authorization');
    var reqHeader = new HttpHeaders({ 
        'Content-Type': 'application/json',
        'Authorization' : token
     });

    return this.http.get(path +'/category/byId/2', {headers: {"jony": "depp"}});
  }
  getAllCategoryData(): Observable<any>{
    return this.http.get(path+'/category/getAll');
  }
}

async function getCategoryData() {
  let token = localStorage.getItem('Authorization');
  const response = await fetch(
      path + '/category/byId/2',
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
