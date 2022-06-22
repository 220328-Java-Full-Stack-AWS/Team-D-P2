package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.services.CategoryService;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;
    private final StorageManager storageManager;
    @Autowired
    public CategoryController(CategoryService categoryService, StorageManager storageManager){
        this.categoryService = categoryService;
        this.storageManager = storageManager;
    }

    @PostMapping
    public void create(@RequestBody Category category){
        Session session = this.storageManager.getSessionFactory().openSession();
        categoryService.create(category,session);
        //session.close();
    }

    @PutMapping
    public Category update(@RequestHeader("id") int id, @RequestBody Category category){
        Session session = this.storageManager.getSessionFactory().openSession();
        categoryService.update(id, category,session);
        //session.close();
        return category;
    }

    @PatchMapping
    public void patch(@RequestBody Category category){
        Session session = this.storageManager.getSessionFactory().openSession();
        categoryService.patch(category,session);
        //session.close();
    }

    @DeleteMapping
    public void delete (@RequestBody Category category){
        Session session = this.storageManager.getSessionFactory().openSession();
        categoryService.delete(category,session);
        //session.close();
    }
  
    @GetMapping("/byId/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") int t){
        Session session = this.storageManager.getSessionFactory().openSession();
        ResponseEntity<Category> out = ResponseEntity.of(categoryService.getById(t,session));
        //session.close();
        return out;
    }

    @GetMapping("/byName/{name}")
    public ResponseEntity<Category> getByName(@PathVariable("name") String t){
        Session session = this.storageManager.getSessionFactory().openSession();
        ResponseEntity<Category> out = ResponseEntity.of(categoryService.getByName(t,session));
        //session.close();
        return out;

    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> getAll(){
        Session session = this.storageManager.getSessionFactory().openSession();

        ResponseEntity<List<Category>> out = ResponseEntity.ok(categoryService.getAll(session));
        //session.close();
        return out;
    }

}
