package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.ProductService;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final StorageManager storageManager;
    private final ProductService productService;

    @Autowired
    public ProductController(StorageManager storageManager, ProductService productService) {
        this.storageManager = storageManager;
        this.productService = productService;

    }


    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        Session session = this.storageManager.getSessionFactory().openSession();
        List<Product> out = productService.getAll(session);
        //session.close();
        return out;
    }

    //get product by productname or id
    @GetMapping("/{productnameorId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct (@PathVariable String productnameorId) {
        Session session = this.storageManager.getSessionFactory().openSession();
        //this checks if parameter is only numeric
        Product out;
        if(productnameorId.matches("^[0-9]*$")){
            out= productService.getProductById(Integer.parseInt(productnameorId),session);
        }else{
            out= productService.getProductByProductname(productnameorId,session);
        }
        //session.close();
        return out;
    }
    @GetMapping("/id/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductId(@PathVariable String productId){
        Session session = this.storageManager.getSessionFactory().openSession();
        Product out = productService.getProductById(Integer.parseInt(productId),session);
        //session.close();
        return out;
    }
    @GetMapping("/name/{productName}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductName(@PathVariable String productName){
        Session session = this.storageManager.getSessionFactory().openSession();
        Product out = productService.getProductByProductname(productName,session);
        //session.close();
        return out;
    }
    //post a new product - auto generate the ID
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Product persistNewProduct (@RequestBody Product product){
        Session session = this.storageManager.getSessionFactory().openSession();
        Product out = productService.createProduct(product,session);
        //session.close();
        return out;
    }

  /*  @GetMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto authorizeProduct (@RequestBody AuthDto authDto) throws Exception {
    return productService.authenticateProduct(authDto);
    //TODO: ResponseEntity<User> use this object to send back a different response for unauthorized
    }*/

    //put (update) an existing user (based on id)
    //TODO NOT WORKING
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct (@RequestBody Product product){
    return productService.update(product);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Product deleteProduct (@RequestBody Product product){
        Session session = this.storageManager.getSessionFactory().openSession();
        Product out = productService.delete(product);
        //session.close();
        return out;
    }
    @GetMapping("/search/findByNameContaining")
    public List <Product>findByNameContaining(@RequestParam("name") String name) {
        Session session = this.storageManager.getSessionFactory().openSession();
        List<Product> out = productService.getProductByMatchingName(name,session);
        //session.close();
        return out;
    }

}