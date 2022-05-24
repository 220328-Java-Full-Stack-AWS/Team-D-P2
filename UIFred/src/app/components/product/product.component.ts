import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product/product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product',
  //templateUrl: './product-grid.component.html',

  templateUrl: './product-table.component.html',
   //templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product[] = [];
  currentCategoryId!: number;
   
  
  constructor(private productService: ProductService,
              private route: ActivatedRoute) { }

  ngOnInit() {
    this.route.paramMap.subscribe(() => {
      this.Product();
    });
    
  }
  

   Product() {

     //Check if "id" parameter is available
     const hasCategoryId: boolean = this.route.snapshot.paramMap.has('id')

     if (hasCategoryId) {
       // get the "id" param string. convert string to a number using the "+" symbol
//       this.currentCategoryId = +this.route.snapshot.paramMap.get('id');
//     }
//     else {
//       // not category id available ... default to category id 1
//       this.currentCategoryId = 1;
//     }

//     // now get the products for the given category id
//     this.productService.getProduct(this.currentCategoryId).subscribe(
//       (      data: Product[]) => {
//         this.product = data;
//       }
//     )
//   }

// }

}
   }
  }

