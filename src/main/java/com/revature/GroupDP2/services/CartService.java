package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.CartRepository;
import com.revature.GroupDP2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    CartRepository cartRepository;
    UserService userService;
    ProductRepository productRepository;

    @Autowired
    public CartService(CartRepository cartRepository,ProductRepository productRepository){
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    public Cart newCart(){
        return cartRepository.create();
    }
    public void newCart(User user) {
        //cartRepository.create(new Cart(user));
    }

    public void newCart(Cart cart) {
        //System.out.println("Service layer" + cart);
        //cartRepository.create(cart);
    }

    public Optional<Cart> getCartByUser(User user) {
        return cartRepository.getByUser(user);
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

    public Cart addProduct(Product product, Integer cartId) {
        Cart cart = getCartById(cartId).get();
        Product nProduct=productRepository.getById(product.getProductId());
        cart.addCartItem(nProduct);
        cartRepository.merge(cart);
        return cart;
    }

    public Cart deleteProduct(Product product, Integer cartId) {
        Cart cart = getCartById(cartId).get();
        System.out.println("Before " + cart);
        cart.deleteCartItem(product);
        System.out.println("After " + cart);
        cartRepository.update(cart);
        return cart;
    }

    public void deleteCartItems(Cart cart, Integer cartId){
        System.out.println("service");
        cartRepository.delete(cart);
    }

    public List<Product> getCartItems(Cart cart) {return cart.getCartItems();}


}
