import { User } from "./User";

export class Payment{
    constructor(){};
    id!:number;
    cardNumber!:string;
    cvvNumber!: string;
    user!:User;
}