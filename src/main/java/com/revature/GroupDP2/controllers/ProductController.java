package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.dtos.AuthDto;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAll() {
        return productService.getAll();
    }

    //get product by productname or id
    @GetMapping("/{productnameorId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct (@PathVariable String productnameorId) {
        //this checks if parameter is only numeric
        if(productnameorId.matches("^[0-9]*$")){
            return productService.getProductById(Integer.parseInt(productnameorId));
        }else{
            return productService.getProductByProductname(productnameorId);
        }
    }
    @GetMapping("/id/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductId(@PathVariable String productId){
        return productService.getProductById(Integer.parseInt(productId));
    }
    @GetMapping("/name/{productName}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProductName(@PathVariable String productName){
        return productService.getProductByProductname(productName);
    }
    //post a new product - auto generate the ID
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Product persistNewProduct (@RequestBody Product product){
        return productService.createProduct(product);
    }

  /*  @GetMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public AuthDto authorizeProduct (@RequestBody AuthDto authDto) throws Exception {
    return productService.authenticateProduct(authDto);
    //TODO: ResponseEntity<User> use this object to send back a different response for unauthorized
    }*/

    //put (update) an existing user (based on id)
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct (@RequestBody Product product){
    return productService.update(product);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public Product deleteProduct (@RequestBody Product product){
    return productService.delete(product);
    }

}