package com.revature.GroupDP2.services;

import com.revature.GroupDP2.model.Cart;
import com.revature.GroupDP2.model.Product;
import com.revature.GroupDP2.model.User;
import com.revature.GroupDP2.repository.CartRepository;
import com.revature.GroupDP2.repository.ProductRepository;
import org.hibernate.Session;
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

    public Cart newCart(Session session){
        return cartRepository.create(session);
    }
    public void newCart(User user,Session session) {
        //cartRepository.create(new Cart(user));
    }

    public void newCart(Cart cart,Session session) {
        //System.out.println("Service layer" + cart);
        //cartRepository.create(cart);
    }

    public Optional<Cart> getCartByUser(User user,Session session) {
        return cartRepository.getByUser(user,session);
    }


    public Optional<Cart> getCartById(Integer cartId,Session session) {
        return cartRepository.getById(cartId,session);
    }

    public void checkout(Cart cart,Session session) {
        cartRepository.delete(cart,session);

    }

    public List<Cart> getAll(Session session) {

        List<Cart> output = cartRepository.getAll(session);

        for(Cart i : output){
            System.out.println(i);
        }

        return output;
    }

    public Cart addProduct(Product product, Integer cartId,Session session) {
        Cart cart = getCartById(cartId,session).get();
        Product nProduct=productRepository.getById(product.getProductId(),session);
        cart.addCartItem(nProduct);
        cartRepository.merge(cart,session);
        return cart;
    }

    public Cart deleteProduct(Product product, Integer cartId,Session session) {
        Cart cart = getCartById(cartId,session).get();
        System.out.println("Before " + cart);
        cart.deleteCartItem(product);
        System.out.println("After " + cart);
        cartRepository.update(cart,session);
        return cart;
    }

    public void deleteCartItems(Cart cart, Integer cartId,Session session){
        System.out.println("service");
        cartRepository.delete(cart,session);
    }

    public List<Product> getCartItems(Cart cart) {return cart.getCartItems();}


}
