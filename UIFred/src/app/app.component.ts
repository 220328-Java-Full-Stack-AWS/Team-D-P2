import { Component,OnInit } from '@angular/core';
import { Category } from './common/Category';
import { ProductService } from './services/product.service';
import { Router } from '@angular/router';
import { CartService } from './services/cart/cart.service';
import { Cart } from './common/Models';
import { ShareService } from './services/share.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  username:any=''
  title = 'UI';
  total: number = 0
  numItems: number = 0
  cart: Cart = new Cart();
  cats:Category[]=[];
  constructor(private productService:ProductService,private router: Router, private cartService: CartService, public shareService:ShareService) {
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
  logout():void{
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("cartId");
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("id");
    window.location.reload();
  }
}

