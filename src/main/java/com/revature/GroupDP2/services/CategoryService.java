package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Category;
import com.revature.GroupDP2.repository.CategoryRepository;
import org.hibernate.Session;
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

    public void create(Category category, Session session){

        categoryRepository.create(category,session);
    }

    public void update(int id, Category category,Session session){

        categoryRepository.update(id, category,session);
    }

    public void patch(Category category,Session session){

        categoryRepository.patch(category,session);
    }

    public void delete(Category category,Session session){

        categoryRepository.delete(category,session);
    }

    public Optional<Category> getById(int t,Session session){
        return categoryRepository.getById(t,session);
    }

    public Optional<Category> getByName(String t,Session session){
        return Optional.ofNullable(categoryRepository.getByCategoryName(t,session));
    }

    public List<Category> getAll(Session session){

        return categoryRepository.getAll(session);
    }

}
