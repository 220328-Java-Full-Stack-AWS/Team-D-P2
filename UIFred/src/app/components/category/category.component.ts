// import { Component, OnInit } from '@angular/core';
// import { Category } from 'src/app/common/category/category';
// import { ProductService } from 'src/app/services/product.service';

// @Component({
//   selector: 'app-category',
//   templateUrl: './category.component.html',
//   styleUrls: ['./category.component.css']
// })
// export class ProductCategoryMenuComponent implements OnInit {

//   Category: Category[] = [];
  
//   constructor(private productService: ProductService) { }

//   ngOnInit() {
//     this.listProductCategories();
//   }

//   listProductCategories() {

//     this.productService.getCategory().subscribe(
//       (      data: Category[]) => {
//         console.log('Categories=' + JSON.stringify(data));
//         this.Category = data;
//       }
//     );
//   }

// }
