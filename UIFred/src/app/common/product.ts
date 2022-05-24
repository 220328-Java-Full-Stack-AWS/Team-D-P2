import { Category } from "./Category";

export class Product {
  constructor(){};
    productId!: string;
    productName!: string;
    description!: string;
    price!: number;
    imageUrl!: string;
    category!: Category;
  static Component: any;
    
}


