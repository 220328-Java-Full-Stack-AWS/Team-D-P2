package com.revature.GroupDP2.controllers;

import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.services.CartService;
import com.revature.GroupDP2.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/products")
    public List<Product> viewCart(@RequestBody Cart cart) {
        return cartService.getCartItems(cart);
    }

    @GetMapping("/all")
    public List<Cart> getAll(){
        return cartService.getAll();
    }

    @PostMapping("/add")
    public void addCart(HttpServletResponse response) {

        Cookie cookie = new Cookie("hello", "sup");

        response.addCookie(cookie);

        Cart cart = new Cart();

        cartService.newCart(cart);

    }

    @PutMapping("/addProduct")
    public void addProduct() {

        // Cart cart = cartService.getCartById();
    }



}



