import { Product } from "./product";
import { User } from "./User";

export class Cart{
    constructor(){};
    id!:number;
    user!:User;
    cartItems!:Product[];
}