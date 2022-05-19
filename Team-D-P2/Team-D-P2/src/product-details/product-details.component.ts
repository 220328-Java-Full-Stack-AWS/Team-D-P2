import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/product';
import { ProductService } from 'src/app/product.service';


@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrls: ['./product-details.component.css']
})
export class ProductDetailsComponent implements OnInit {

  id!: number; 
  employee!: Product; 
    product: any;
  constructor(private route: ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.product = new Product();
    this.productService['getEmployeeById'](this.id).subscribe( (data: any) => {
      this.product = data;
    });
  }

}