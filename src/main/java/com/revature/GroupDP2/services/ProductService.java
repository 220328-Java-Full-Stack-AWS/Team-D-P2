package com.revature.GroupDP2.services;

import com.revature.GroupDP2.controllers.ProductController;
import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll(Session session) {
        return productRepository.getAll(session);
    }

    public Product createProduct (Product p,Session session) {
        productRepository.create(p,session);
        return p;
    }
    public void updateProduct(Product p,Session session) {
         productRepository.update(p,session);
    }
    public void deleteProduct (Object product,Session session) {
         productRepository.delete((Product) product,session);
    }

    public Product getProductById(Integer id,Session session) {
        return productRepository.getById(id,session);
    }


    public Product getProductByProductname(String productnameorId,Session session) {

       return productRepository.getProductByProductName(productnameorId,session);
    }
    public List<Product> getProductByMatchingName(String productName,Session session){
        return productRepository.getProductByMatchingName(productName,session);
    }

    public AuthDto authenticateProduct(AuthDto authDto) {
        return null;
    }

    public Product update(Product product) {
        return null;
    }

    public Product delete(Product product) {
        return null;
    }


}

