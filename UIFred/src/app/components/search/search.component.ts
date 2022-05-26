import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  constructor(private router: Router, private productService: ProductService) { }
  products:Product[]

  ngOnInit() {
  }

  doSearch(value: string) {
    console.log(`value=${value}`);
    this.productService.searchProduct(value).subscribe((data:any) => {this.products =data;console.log(this.products[0].productName)})
    
  }
}
