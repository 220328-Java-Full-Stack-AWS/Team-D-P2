package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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

    @PutMapping
    public void update(@RequestBody Category category){

        categoryService.update(category);
    }

    @PatchMapping
    public void patch(@RequestHeader("id") int id, @RequestBody Category category){

        categoryService.patch(id, category);
    }

    @DeleteMapping
    public void delete (@RequestBody Category category){

        categoryService.delete(category);
    }

    @GetMapping("/byId")
    public Optional<Category> getById(@RequestHeader("id") int t){
        return categoryService.getById(t);
    }

    @GetMapping
    public List<Category> getAll(){

        return categoryService.getAll();
    }


}
