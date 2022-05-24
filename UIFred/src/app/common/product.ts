import { Category } from "./Category";

export class Product {
  constructor(){};
    productId: number=0;
    productName: string="";
    description: string="";
    price: number=0;
    imageUrl: string="";
    category!: Category;
  static Component: any;
    
}


