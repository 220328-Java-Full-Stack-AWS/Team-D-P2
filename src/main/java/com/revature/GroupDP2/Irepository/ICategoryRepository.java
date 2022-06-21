package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Category;
import org.hibernate.Session;

import java.util.List;

public interface ICategoryRepository<Category> extends IGenericRepository<Category>{
    Category getByCategoryName (String t,Session session);

    //ADD METHOD LATER
    List<Category> getAll(Session session);

    void create(com.revature.GroupDP2.model.Category category,Session session);
}
