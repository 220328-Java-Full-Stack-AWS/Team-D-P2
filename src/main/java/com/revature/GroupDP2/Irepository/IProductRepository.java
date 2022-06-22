package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;
import org.hibernate.Session;

import java.util.List;

public interface IProductRepository<T> extends IGenericRepository<Product> {

    T  getByUserId(int l,Session session);

    T getByCategoryId(int l, Session session);

    T getById(Integer id,Session session);


}
