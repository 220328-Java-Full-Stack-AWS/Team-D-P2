package com.revature.GroupDP2.model;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//Product class - corresponds to GroupDP2_product in db

@Entity
@Table(name="product",schema = "groupd")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn
    private Category category;

    @ManyToMany
    @Column
    private List<Cart> productCart;

    public Product(Category category, String productName, String description, Double price) {
        this.category = category;
        this.productName = productName;
        this.description = description;
        this.price = price;
        productCart=new ArrayList<>();
    }
    public Product() {
    productCart=new ArrayList<>();
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_Name() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public List<Cart> getProductCart() {
        return productCart;
    }

    public void setProductCart(List<Cart> productCart) {
        this.productCart = productCart;
    }
    public void addItem(Cart cart){
        productCart.add(cart);
    }
}

