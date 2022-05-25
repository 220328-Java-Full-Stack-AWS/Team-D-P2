package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
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
    public Category update(@RequestHeader("id") int id, @RequestBody Category category){

        categoryService.update(id, category);
        return category;
    }

    @PatchMapping
    public void patch(@RequestBody Category category){

        categoryService.patch(category);
    }

    @DeleteMapping
    public void delete (@RequestBody Category category){

        categoryService.delete(category);
    }
  
    @GetMapping("/byId/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") int t){

        return ResponseEntity.of(categoryService.getById(t));
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Category> getByName(@PathVariable("name") String t){

        return ResponseEntity.of(categoryService.getByName(t));

    }
    @GetMapping("/getAll")
    public ResponseEntity<? extends List> getAll(){

        return ResponseEntity.ok().body(categoryService.getAll());
    }

}
