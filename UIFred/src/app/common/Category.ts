import { Product } from "./product";

export class Category{
    constructor(){};
    id!:number;
    categoryName!:string;
    products!:Product[];
}