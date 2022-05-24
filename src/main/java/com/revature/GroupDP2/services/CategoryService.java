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

    public void update(int id, Category category){

        categoryRepository.update(id, category);
    }

    public void patch(Category category){

        categoryRepository.patch(category);
    }

    public void delete(Category category){

        categoryRepository.delete(category);
    }

    public Optional<Category> getById(int t){
        return categoryRepository.getById(t);
    }

    public Optional<Category> getByName(String t){return Optional.ofNullable(categoryRepository.getByCategoryName(t));}

    public List<Category> getAll(){

        return categoryRepository.getAll();
    }

}
