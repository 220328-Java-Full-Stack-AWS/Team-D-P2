package com.revature.GroupDP2.services;

import com.revature.GroupDP2.controllers.ProductController;
import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.repository.ProductRepository;
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

    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Product createProduct (Product p) {
        productRepository.create(p);
        return p;
    }
    public void updateProduct(Product p) {
         productRepository.update(p);
    }
    public void deleteProduct (Object product) {
         productRepository.delete((Product) product);
    }

    public Product getProductById(Integer id) {
        return productRepository.getById(id);
    }


    public Product getProductByProductname(String productnameorId) {

       return productRepository.getProductByProductName(productnameorId);
    }
    public List<Product> getProductByMatchingName(String productName){
        return productRepository.getProductByMatchingName(productName);
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

