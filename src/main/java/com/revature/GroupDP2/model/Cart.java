package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cart", schema="groupd")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @OneToOne(mappedBy = "cart")
    @JoinColumn
    @JsonBackReference
    private User user;

    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @Column
    private List<Product> cartItems;


    public Cart(User user) {
        this.user = user;
        cartItems = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", user=" + user +
                ", cartItems=" + cartItems +
                '}';
    }

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addCartItem(Product product){
        cartItems.add(product);
    }

    public void deleteCartItem(Product product){
        System.out.println(product.getProductName());
        cartItems.removeIf(item -> item.getProductId() == product.getProductId());}

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public User getUser() {return this.user;}

    public void setUser(User user) {this.user = user;}

    public List<Product> getCartItems() {return cartItems;}

    public void setCartItems(List<Product> cartItems) {this.cartItems = cartItems;}

}
