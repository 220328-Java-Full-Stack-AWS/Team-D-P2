import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';

@Component({
  selector: 'app-product',
  //templateUrl: ',/product-grid.component.html',
  templateUrl: './product-table.component.html',
   //templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product[] = [];
   
  
  constructor(private productService: ProductService) { }

  ngOnInit() {
    this.Product();
  }

  Product() {
    this.productService.getProduct().subscribe(
      data => {
        this.product = data;
      }
    )
  }

}
