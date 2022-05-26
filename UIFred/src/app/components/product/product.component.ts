import { Component, OnInit } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';
import { Product } from 'src/app/common/product';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'src/app/common/Category';
import { CartService } from '../../services/cart/cart.service';

@Component({
  selector: 'app-product',
  //templateUrl: './product-grid.component.html',

  templateUrl: './product-table.component.html',
   //templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  product: Product[]=[];  
  constructor(private cartService:CartService,private productService: ProductService,private route: ActivatedRoute,private router: Router) { 
    this.router.routeReuseStrategy.shouldReuseRoute = () => {
      return false;
    };
  }

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
    this.productService.getCategoryName(categoryName).subscribe((cat:Category)=>{
      let fakeCategory= new Category()
      fakeCategory.id=cat.id;
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
      fakeCategory.id=c.id;
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
      //add to cart here
      let cartId:any=sessionStorage.getItem("cartId")
      if(cartId){
        this.cartService.addProduct(cartId,product).subscribe(()=>{})
      }else{
        window.alert("You must be logged in first!")
      }
    }

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

