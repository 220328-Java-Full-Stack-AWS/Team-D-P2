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

    @GetMapping("/products")
    public List<Product> viewCart(@RequestBody Cart cart) {
        return cartService.getCartItems(cart);
    }
//todo:this operation probably should not be accessible via api - will
    /*
    @GetMapping("/all")
    public List<Cart> getAll(){
        return cartService.getAll();
    }
*/
    @PostMapping("/add")
    public void addCart(@RequestBody Cart cart) {
        cartService.newCart(cart);
    }

    @PutMapping("/addProduct")
    public void addProduct(@RequestHeader Integer cartId, @RequestBody Product product) {
        cartService.addProduct(product, cartId);
    }

    @PutMapping("/deleteProduct")
    public void deleteProduct(@RequestHeader Integer cartId, @RequestBody Product product) {
        cartService.deleteProduct(product, cartId);
    }



}



