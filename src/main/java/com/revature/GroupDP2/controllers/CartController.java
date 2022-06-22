package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.CartService;
import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.util.StorageManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;
    private final StorageManager storageManager;
    @Autowired
    public CartController(CartService cartService, StorageManager storageManager) {
        this.cartService = cartService;
        this.storageManager = storageManager;
    }

    @GetMapping
    public Cart getCart(@RequestHeader("cartId") Integer cartId) {
        Session session = this.storageManager.getSessionFactory().openSession();
        Cart out = cartService.getCartById(cartId,session).get();
        //session.close();
        return out;
    }

    @GetMapping("/viewCart")
    public List<Product> viewCart(@RequestBody Cart cart) {
        //this may cause problems, but I think it does nothing
        return cartService.getCartItems(cart);
    }


//todo:this operation probably should not be accessible via api - will
    @GetMapping("/all")
    public List<Cart> getAll(){
        Session session = this.storageManager.getSessionFactory().openSession();
        List<Cart> out = cartService.getAll(session);
        //session.close();
        return out;
    }

    @PostMapping
    public void addCart(@RequestBody Cart cart) {
        Session session = this.storageManager.getSessionFactory().openSession();
        cartService.newCart(cart,session);
        //session.close();
    }

    @PutMapping("/addProduct")
    public void addProduct(@RequestHeader("cartId") Integer cartId, @RequestBody Product product) {
        Session session = this.storageManager.getSessionFactory().openSession();
        cartService.addProduct(product, cartId,session);
        //session.close();
    }

    @PutMapping("/deleteProduct")
    public void deleteProduct(@RequestHeader("cartId") Integer cartId, @RequestBody Product product) {
        Session session = this.storageManager.getSessionFactory().openSession();
        cartService.deleteProduct(product, cartId,session);
        //session.close();
    }
    @PutMapping("/deleteProductItems")
    public void deleteProductItems(@RequestHeader("cartId") Integer cartId, @RequestBody Cart cart) {
        System.out.println("we are");
        Session session = this.storageManager.getSessionFactory().openSession();
        cartService.deleteCartItems(cart, cartId,session);
        //session.close();
    }

}



