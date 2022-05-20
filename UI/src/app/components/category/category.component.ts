import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../../services/category/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  result : Category = {
    id : 0,
    categoryName : "" 
    
  }

  search(){
    this.categoryService.getCategoryData().subscribe((data: any) => {
      this.result = {
        id : data.id,
        categoryName : data.categoryName
      }
    })
  }

  constructor(private categoryService:  CategoryService) { }

  ngOnInit(): void {
  }

}

class Category {
  
  id : number = 0
  categoryName : string = ""

  constructor () {}

}

