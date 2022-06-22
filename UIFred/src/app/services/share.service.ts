import { Injectable } from '@angular/core';
import { Cart } from '../common/Models';
import { CartService } from './cart/cart.service';

@Injectable({
  providedIn: 'root'
})
export class ShareService {

  constructor(private cartService:CartService) { 
    //this.router.routeReuseStrategy.shouldReuseRoute = () => {
    //  return false;
    //};
  this.getCart();
  }
  total:number=0;
  items:number=0;
  cart=new Cart();
  public totalPrice() {
    let prodSum: number = 0
    for (let product of this.cart.cartItems) {
      prodSum += product.price;
    }
    this.total = prodSum;
    console.log(this.cart);
    this.items = this.cart.cartItems.length;
    console.log(this.items);
  }
  public getCart() {
    console.log("get cart called");
    let cartId = sessionStorage.getItem("cartId");
    
    this.cartService.getCart(cartId).subscribe((cart: Cart) => {
      
      this.cart = cart;
      this.totalPrice()
    })
    
  }
}
