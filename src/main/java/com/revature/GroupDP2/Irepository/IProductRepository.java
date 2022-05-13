package com.revature.GroupDP2.Irepository;

import com.revature.GroupDP2.model.Product;

import java.util.List;

public interface IProductRepository<T> extends IGenericRepository<Product> {

    Product getByUserId(int l);

    Product getByCategoryId(int l);

    Object getById(Integer id);


}
