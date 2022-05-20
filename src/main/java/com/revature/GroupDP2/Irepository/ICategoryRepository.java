package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Category;

import java.util.List;

public interface ICategoryRepository<Category> extends IGenericRepository<Category>{
    Category getByCategoryName (Category category);

    //ADD METHOD LATER
    List<Category> getAll();
}
