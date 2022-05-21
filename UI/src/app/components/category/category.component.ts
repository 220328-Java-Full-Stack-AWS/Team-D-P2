import { Component, OnInit } from '@angular/core';
import { Category } from '../../common/Models';
import { CategoryService } from '../../services/category/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  result : Category = {
    categoryId : 0,
    categoryName : "" ,
    products:[]
  }
  categories: Category[]=[]
  search(){
    this.categoryService.getCategoryData().subscribe((data: Category) => {
      //this.result = {
      //  categoryId : data.categoryId,
      //  categoryName : data.categoryName,
      //  products: data.product
      //}
      this.result=data;
    })
  }
  get(){
    this.categoryService.getAllCategoryData().subscribe((data:Category[]) =>{
this.categories=data;
    })
    console.log(this.categories);
  }

  constructor(private categoryService:  CategoryService) { }

  ngOnInit(): void {
  }

}

