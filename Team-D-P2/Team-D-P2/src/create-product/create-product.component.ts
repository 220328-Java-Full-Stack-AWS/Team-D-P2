
import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/product.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  [x: string]: any;

  employee: Product = new Product();
  constructor(private productService: ProductService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveEmployee(){
    this.productService['createProduct'](this['product']).subscribe( (data: any) =>{
      console.log(data);
      this['goToProductList']();
    },
        (    error: any) => console.log(error));
  }

  goToProductList(){
    this.router.navigate(['/product']);
  }
  
  onSubmit(){
    console.log(this['product']);
    this['saveProduct']();
  }
}