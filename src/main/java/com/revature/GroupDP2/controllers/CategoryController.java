package com.revature.GroupDP2.controllers;


import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public void create(@RequestBody Category category){

        categoryService.create(category);
    }

    @GetMapping("/getAll")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

}
