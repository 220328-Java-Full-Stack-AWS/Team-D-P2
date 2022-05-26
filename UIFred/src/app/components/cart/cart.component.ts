import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/common/User';
import { CartService } from 'src/app/services/cart/cart.service';
import { Cart, Product, Payment } from '../../common/Models';



@Component({
  selector: 'app-test',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {


  public cart: Cart = new Cart();
  public sStorage: any = sessionStorage.getItem("user")
  public user: any = JSON.parse(this.sStorage);
  public total: number = 0;
  public cardNumber = "";
  public expiration = "";
  public cvv = "";

  constructor(private cartService: CartService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    }
   }

  ngOnInit(): void {

    //this.getCart()
    
  }

  public getCart() {
    let cartId = sessionStorage.getItem("cartId");
    console.log("this is" + cartId);
    this.cartService.getCart(cartId).subscribe((cart: Cart) => this.cart = cart)
  }

  public addProduct(body: Product) {
    let cartId = localStorage.getItem("cartId");
    this.cartService.addProduct(cartId, body);
  }

  public deleteProduct(body: Product) {
    let cartId = localStorage.getItem("cartId");
    this.cartService.deleteProduct(cartId, body);
  } 

  public populatePayment(payment: Payment) {

    this.cardNumber = payment.cardNumber;
    this.expiration = payment.expirationDate;
    this.cvv = payment.cvvNumber

    console.log(this.cardNumber)
    console.log(this.expiration)
    console.log(this.cvv)

  }

  public totalPrice() {

    let prodSum: number = 0

    for (let product of this.cart.cartItems) {
      prodSum += product.price;
    }
    this.total = prodSum
}

}


