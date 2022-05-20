package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

import java.util.List;

public interface IProductRepository<T> extends IGenericRepository<Product> {

    T  getByUserId(int l);

    T getByCategoryId(int l);

    T getById(Integer id);


}
