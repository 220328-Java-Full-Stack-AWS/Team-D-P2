package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.CartService;
import com.revature.GroupDP2.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public List<Product> viewCart(@RequestBody Cart cart) {
        return cartService.getCartItems(cart);
    }
//todo:this operation probably should not be accessible via api - will

    @GetMapping("/all")
    public List<Cart> getAll(){
        return cartService.getAll();
    }

    @PostMapping
    public void addCart(@RequestBody Cart cart) {
        cartService.newCart(cart);
    }

    @PutMapping
    public void addProduct(@RequestHeader Integer cartId, @RequestBody Product product) {
        cartService.addProduct(product, cartId);
    }

    @DeleteMapping
    public void deleteProduct(@RequestHeader Integer cartId, @RequestBody Product product) {
        cartService.deleteProduct(product, cartId);
    }



}



