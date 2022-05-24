import { Cart } from "src/app/common/cart";
import {Payment} from "src/app/common/Payment";
export class User{
    constructor(){}
    id!:number;
    username!:string;
    password!:string;
    firstName!:string;
    enabled!:boolean;
    lastName!:string;
    email!:string;
    phone!:string;
    streetName!:string;
    city!:string;
    state!:string;
    zipCode!:string;
    cart!:Cart;
    paymentMethods!:Payment[];
}
