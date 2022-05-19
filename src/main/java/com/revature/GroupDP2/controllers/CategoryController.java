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

    @PostMapping("{categoryName}")
    //@RequestMapping(value = "/{categoryName}", method = RequestMethod.POST)
    @ResponseBody
    public void create(@PathVariable String categoryName){
        Category category = new Category(categoryName);
        categoryService.create(category);
    }

    @PutMapping
    public void update(@RequestHeader("id") int id, @RequestBody Category category){

        categoryService.update(id, category);
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
