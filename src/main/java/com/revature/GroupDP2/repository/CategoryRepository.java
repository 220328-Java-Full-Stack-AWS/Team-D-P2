package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.ICategoryRepository;
import com.revature.GroupDP2.model.Category;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;


@Component
public class CategoryRepository implements ICategoryRepository<Category>{


    @Override
    public void create(Category category, Session session) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.save(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    @Override
    public void update(Category category,Session session) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.update(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    public void update(int id, Category category,Session session) {
        if (session != null){
            Transaction transaction = session.beginTransaction();
            category.setCategoryId(id);
            session.update(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    public void patch(Category category,Session session){
        if (session != null){
            Transaction transaction = session.beginTransaction();
            session.merge(category);
            transaction.commit();
        }
        else{
            //throw an exception
        }
    }

    @Override
    public void delete(Category category,Session session) {
            Transaction transaction = session.beginTransaction();
            TypedQuery<Category> query = session.createQuery("DELETE FROM Category WHERE categoryName = :categoryName");
            query.setParameter("categoryName",category.getCategoryName());
            query.executeUpdate();
            transaction.commit();

    }

    @Override
    public Optional<Category> getById(int t,Session session) {
            Transaction transaction = session.beginTransaction();
            Category category = session.get(Category.class,t);
            transaction.commit();
        return Optional.ofNullable(category);
    }

    public Category getByCategoryName(String categoryName,Session session) {
            TypedQuery<Category> query = session.createQuery("FROM Category WHERE categoryName = :categoryName", Category.class);
            query.setParameter("categoryName", categoryName);
            Category category = query.getSingleResult();
        return category;
    }

    @Override
    public List<Category> getAll(Session session) {
        TypedQuery<Category> query = session.createQuery("FROM Category", Category.class);
        return query.getResultList();
    }

}


