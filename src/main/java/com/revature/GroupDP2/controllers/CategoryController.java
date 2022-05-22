package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    //@RequestMapping(value = "/{categoryName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public Category create(@RequestBody Category category){
        categoryService.create(category);
        return category;
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

    @GetMapping("/{id}")
    public Optional<Category> getById(@PathVariable("id") int t){
        return categoryService.getById(t);
    }

    @GetMapping
    public List<Category> getAll(){

        return categoryService.getAll();
    }


}
