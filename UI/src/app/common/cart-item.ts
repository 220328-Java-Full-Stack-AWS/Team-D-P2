import { Product } from './product';

export class CartItem {

    id: number;
    name: string;
    description: string;
    unitPrice: number;
    categortyId: number;
    imageUrl: string;
    

    quantity!: number;

    constructor (product, Product) {
        this.id = product.id;
        this.name = product.Name;
        this.imageUrl = product.imageUrl;
        this.unitPrice = product.unitPrice;

        this.quantity = 1;
    }
}
