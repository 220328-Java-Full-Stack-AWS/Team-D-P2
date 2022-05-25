import { Component,OnInit } from '@angular/core';
import { Category } from './common/Category';
import { ProductService } from './services/product.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  username:any=''
  title = 'UI';
  cats:Category[]=[];
  constructor(private productService:ProductService,private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };
   }
  ngOnInit():void{
  this.username=sessionStorage.getItem("username")
  this.productService.getCategoryAll().subscribe((cat:Category[])=>{
    this.cats=cat;
  })
  }
}
