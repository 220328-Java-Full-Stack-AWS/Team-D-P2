package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Product class - corresponds to GroupDP2_product in db

@Entity
@Table(name="product",schema = "groupd")
@JsonIgnoreProperties
public class Product {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @NotEmpty @Size(min = 2, max = 255, message = "product name should be between 2 and 255 characters")
    @Column(name = "product_name",unique = true)
    private String productName;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotEmpty @Digits(integer = 1000, fraction = 2)
    @Column(name = "price")
    private Double price;

    @NotEmpty
    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn
    @JsonBackReference
    private Category category;
  
    //@ManyToMany
    //@Column
    //private List<Cart> productCart;


    public Product(Category category, String productName, String description, Double price, String imageUrl) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        //productCart=new ArrayList<>();
    }
    public Product() {
    //productCart=new ArrayList<>();
    }

    public static void setCategoryId(Integer integer) {

    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
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

    public Integer getCategoryId() {
        return null;
    }

    public String getImageUrl() {return imageUrl;}

    public void setImageUrl(String imageUrl) {this.imageUrl = imageUrl;}

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}


