package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
    //@RequestMapping(value = "/{categoryName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody Category category){
        categoryService.create(category);
    }

    @PutMapping
    public void update(@RequestHeader("id") int id, @RequestBody Category category){

        categoryService.update(id, category);
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
    public ResponseEntity<Category> getById(@RequestHeader("Authorization") String token, @PathVariable("id") int t){
        System.out.println("we are in a controller and token is " + token);
        if (token.equals("\"Bearer null\"")){
            return ResponseEntity.status(401).build();
        }
        else {
            return ResponseEntity.of(categoryService.getById(t));
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<? extends List> getAll(@RequestHeader("Authorization") String token){
        System.out.println("we are in a controller and token is " + token);
        if (token.equals("\"Bearer null\"")){
            return ResponseEntity.status(401).build();
        }
        else {
            return ResponseEntity.ok().body(categoryService.getAll());
        }
    }


}
