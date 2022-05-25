package com.revature.GroupDP2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "groupd")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @NotEmpty @Size(min = 2, max = 255, message = "category name should be between 2 and 255 characters")
    @Column(name = "category_name",unique=true)
    private String categoryName;

    @Column
    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade = {CascadeType.DETACH, CascadeType.MERGE,CascadeType.REFRESH, CascadeType.PERSIST}, fetch=FetchType.LAZY)
    List<Product> products = new ArrayList<>();

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
