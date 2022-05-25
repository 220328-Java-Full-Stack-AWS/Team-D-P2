import { Component,OnInit } from '@angular/core';
import { Category } from './common/Category';
import { ProductService } from './services/product.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'UI';
  cats:Category[]=[];
  constructor(private productService:ProductService) { }
  ngOnInit():void{
  this.productService.getCategoryAll().subscribe((cat:Category[])=>{
    this.cats=cat;
  })
  }
}
