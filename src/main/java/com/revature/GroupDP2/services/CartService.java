package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository){

        this.cartRepository = cartRepository;
        System.out.println(cartRepository);
    }


    public void newCart(User user) {
        cartRepository.create(new Cart(user));
    }

    public void newCart(Cart cart) {
        System.out.println("Service layer" + cart);
        cartRepository.create(cart);
    }

    public Optional<Cart> getCartById(Integer cartId) {
        return cartRepository.getById(cartId);
    }

    public void checkout(Cart cart) {
        cartRepository.delete(cart);

    }

    public List<Cart> getAll() {

        List<Cart> output = cartRepository.getAll();

        for(Cart i : output){
            System.out.println(i);
        }

        return output;
    }

    public Cart addProduct(Product product, Cart cart) {
        cart.addCartItem(product);
        cartRepository.update(cart);
        return cart;
    }

    public Cart deleteProduct(Product product, Cart cart) {
        cart.deleteCartItem(product);
        cartRepository.update(cart);
        return cart;
    }

    public List<Product> getCartItems(Cart cart) {return cart.getCartItems();}


}
