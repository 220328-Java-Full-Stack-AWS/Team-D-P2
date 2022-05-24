import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { ActivatedRoute } from '@angular/router';
import { Category } from 'src/app/common/Category';

@Component({
  selector: 'app-product',
  //templateUrl: './product-grid.component.html',

  templateUrl: './product-table.component.html',
   //templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product[]=[];   
  
  constructor(private productService: ProductService,private route: ActivatedRoute) { }

  ngOnInit() {
    //get category from path if exists
    let categoryName:any=this.route.snapshot.paramMap.get('categoryName');
    console.log(categoryName)
    if(categoryName){
      //search in category
      this.getCategory(categoryName)
    }else{
      //search in 
    this.getProductsAll();
    }

  }
  getCategory(categoryName:string){
    let search= new Category();
    search.categoryName=categoryName;
    this.productService.getCategoryName(search).subscribe((cat:Category)=>{
      let fakeCategory= new Category()
      fakeCategory.id=cat.id;
      fakeCategory.categoryName=cat.categoryName;
      for(let p of cat.products){
        p.category=fakeCategory;
      }
      this.product= this.product.concat(cat.products) 
    })
  }
  getProductsAll(){
    this.productService.getCategoryAll().subscribe((cat:Category[])=>{
    for(let c of cat){
      let fakeCategory= new Category()
      fakeCategory.id=c.id;
      fakeCategory.categoryName=c.categoryName;
      for(let p of c.products){
        p.category=fakeCategory;
      }
      this.product= this.product.concat(c.products)
    }      
    })
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

