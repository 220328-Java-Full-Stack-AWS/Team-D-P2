package com.revature.GroupDP2.repository;

import com.revature.GroupDP2.Irepository.IProductRepository;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;


import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


@Component
public class ProductRepository implements IProductRepository<Product> {


    @Override
    public void create(Product p,Session session) {
        Transaction transaction = session.beginTransaction();
        session.save(p);
        transaction.commit();
    }

    @Override
    public void update(Product p,Session session) {
        Transaction transaction = session.beginTransaction();
        session.update(p);
        transaction.commit();
    }

    @Override
    public Optional<Product> getById(int t,Session session) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE id = :id", Product.class);
        query.setParameter("id", t);
        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public void delete(Product p,Session session) {
        Transaction transaction = session.beginTransaction();
        session.delete(p);
        transaction.commit();
    }

    @Override
    public Product getByCategoryId(int id,Session session) {
        TypedQuery<Product> query = session.createQuery("FROM Product WHERE categoryId = :categoryId", Product.class);
        query.setParameter("categoryId", id);
        return query.getSingleResult();
    }

    @Override
    public List<Product> getAll(Session session) {
        TypedQuery<Product> query = session.createQuery("FROM Product", Product.class);
        return query.getResultList();
    }

    public Product getProductByProductName(String productnameorId,Session session) {
        Transaction transaction = session.beginTransaction();
        TypedQuery<Product>query = session.createQuery("From Product where productName = : productName");
        query.setParameter("productName", productnameorId);
        Product product = query.getSingleResult();
        transaction .commit();
        return product;
    }
    public List<Product> getProductByMatchingName(String productName,Session session){
        Transaction transaction = session.beginTransaction();
        String hql = "From Product where productName like :productName";
        TypedQuery<Product> query = session.createQuery(hql);
        query.setParameter("productName",productName + "%");
        List<Product> productList = query.getResultList();
        transaction.commit();
        return productList;
    }

    @Override
    public Product getById(Integer id,Session session) {
        Transaction transaction = session.beginTransaction();
        TypedQuery<Product>query = session.createQuery("From Product where productId = : productId");
        query.setParameter("productId", id);
        Product product = query.getSingleResult();
        transaction .commit();
        return product;
    }

    @Override
    public Product getByUserId(int l,Session session) {
        return null;
    }

}

