import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { range } from 'rxjs';
import { User } from 'src/app/common/User';
import { CartService } from 'src/app/services/cart/cart.service';
import { ShareService } from 'src/app/services/share.service';
import { Cart, Product, Payment } from '../../common/Models';



@Component({
  selector: 'app-test',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  //public cart: Cart = new Cart();
  public sStorage: any = sessionStorage.getItem("user")
  public user: any = JSON.parse(this.sStorage);
  public total: number = 0;
  public cardNumber = "";
  public expiration = "";
  public cvv = "";

  constructor(public shareService:ShareService,private cartService: CartService, private router: Router) {
    //this.router.routeReuseStrategy.shouldReuseRoute = () => {
    //  return false;
    //}
   }

  ngOnInit(): void {
    //this.getCart();
  }

  //public getCart() {
  //  let cartId = sessionStorage.getItem("cartId");
  //  console.log("this is " + cartId);
  //  this.cartService.getCart(cartId).subscribe((cart: Cart) => {this.cart = cart; this.totalPrice(cart)})
  //}

  public addProduct(body: Product) {
    let cartId = localStorage.getItem("cartId");
    this.cartService.addProduct(cartId, body);

  }

  public deleteProduct(body: Product) {
    console.log(body);
    console.log("WITHIN DELETEPRODUCT COMPONENT");
    let cartId = sessionStorage.getItem("cartId");
    this.cartService.deleteProduct(cartId, body).subscribe((data:any)=>{
      this.shareService.cart.cartItems.splice(this.shareService.cart.cartItems.indexOf(body),1);
      this.shareService.totalPrice();
    });
    
    //this.cart
    //window.location.reload()
  } 

  public deleteAll() {
    let cart = new Cart();
    console.log("WITHIN DELETEALL COMPONENT");
    let cartId = sessionStorage.getItem("cartId");
    cart.id = Number(sessionStorage.getItem("cartId"));
    this.cartService.deleteProductCart(cartId,cart).subscribe((data:any) => {
      this.shareService.cart.cartItems=[];
      this.shareService.totalPrice();
      //this.totalPrice(this.shareService.cart);
    });
    //window.location.href = "cart"
    //window.location.reload()
  }

  public populatePayment(payment: Payment) {

    this.cardNumber = payment.cardNumber;
    this.expiration = payment.expirationDate;
    this.cvv = payment.cvvNumber

  }
/*
  public totalPrice(cart: Cart) {

    let prodSum: number = 0

    for (let product of cart.cartItems) {
      prodSum += product.price;
    }
    this.total = prodSum

    sessionStorage.setItem("totalPrice", String(prodSum));
}
*/
}


