import { Component, OnInit } from '@angular/core';
import { Cart, User, Product, Payment } from '../../common/Models';

@Component({
  selector: 'app-test',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  public user = new User("uname","pword","fname","lname","email");
  public prod1 = new Product("Some Thing","descrip",20.22,"assets/images/products/mousepads/mousepad-luv2code-1019.png");
  public cart = new Cart(1,this.user,[this.prod1]);
  public pay1 = new Payment("1234", "11/24", 234);
  public pay2 = new Payment("12345", "10/10", 312);
  public payments = [this.pay1,this.pay2];


  constructor() { }

  ngOnInit(): void {
  }

}
