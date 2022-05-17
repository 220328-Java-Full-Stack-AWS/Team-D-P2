package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public void create(Category category){

        categoryRepository.create(category);
    }

    public void update(Category category){

        categoryRepository.update(category);
    }

    public void patch(int id, Category category){

        categoryRepository.patch(id, category);
    }

    public void delete(Category category){

        categoryRepository.delete(category);
    }

    public Optional<Category> getById(int t){
        return categoryRepository.getById(t);
    }

    public List<Category> getAll(){

        return categoryRepository.getAll();
    }

}
