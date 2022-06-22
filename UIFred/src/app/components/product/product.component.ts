import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { ActivatedRoute, Router } from '@angular/router';

import { CartService } from '../../services/cart/cart.service';
import { ShareService } from 'src/app/services/share.service';
import { Category, Product } from 'src/app/common/Models';

@Component({
  selector: 'app-product',
  //templateUrl: './product-grid.component.html',

  templateUrl: './product-table.component.html',
   //templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  //productName: string = ""

  searchMode: Boolean;
  product: Product[]=[];
  constructor(private shareService:ShareService,private productService: ProductService,private route: ActivatedRoute,private router: Router,private cartService: CartService) {
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };


  }

  ngOnInit() {
    //get category from path if exists
    let categoryName:any=this.route.snapshot.paramMap.get('categoryName');

    if(categoryName){
      //search in category
      this.getCategory(categoryName)
    }else{
      //search in
    this.getProductsAll();
    }

  }
  getCategory(categoryName:string){
    this.productService.getCategoryName(categoryName).subscribe((cat:Category)=>{
      let fakeCategory= new Category()
      fakeCategory.categoryId=cat.categoryId;
      fakeCategory.categoryName=cat.categoryName;
      for(let p of cat.products){
        p.category=fakeCategory;
        console.log(p)
      }
      this.product= this.product.concat(cat.products)
    })
  }
  getProductsAll(){
    this.productService.getCategoryAll().subscribe((cat:Category[])=>{
    for(let c of cat){
      let fakeCategory= new Category()
      fakeCategory.categoryId=c.categoryId;
      fakeCategory.categoryName=c.categoryName;
      for(let p of c.products){
        p.category=fakeCategory;
      }
      this.product= this.product.concat(c.products)
    }
    })
  }

  popup(product:Product){
    if(window.confirm("add "+product.productName+" to cart?")){
      let x:string=sessionStorage.getItem("cartId");
      if(x){
        this.cartService.addProduct(x,product).subscribe((data:any)=>{
          this.shareService.cart.cartItems.push(product)
        });
      }else{
        window.alert("Cannot add item. You must register first");
      }
    }





  }

  search() {

    this.searchMode = this.route.snapshot.paramMap.has('keyword');

    if (this.searchMode) {
      this.handleSearchProduct();
    }




  }
  handleSearchProduct() {
    const theKeyword:string = this.route.snapshot.paramMap.get('keyword');

    // now search for products using keyword
    this.productService.searchProduct(theKeyword).subscribe(
      (          data: Product[]) => {
        this.product = data;

      }

    );
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

function data(data: any, arg1: (Product: any) => void) {
  throw new Error('Function not implemented.');
}

