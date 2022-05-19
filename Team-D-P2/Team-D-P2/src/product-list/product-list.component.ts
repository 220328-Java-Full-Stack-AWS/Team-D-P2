import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  product:[] = [];

  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
    this.getProduct();
  }

  private getProduct(){
    this.productService['getProductList']().subscribe((data: any) => {
      this.product = data;
    });
  }

  productDetails(id: number){
    this.router.navigate(['product-details', id]);
  }

  updateProduct(id: number){
    this.router.navigate(['update-product', id]);
  }

  deleteProduct(id: number){
    this.productService['deleteEmployee'](id).subscribe( (data: any) => {
      console.log(data);
      this.getProduct();
    })
  }
}
