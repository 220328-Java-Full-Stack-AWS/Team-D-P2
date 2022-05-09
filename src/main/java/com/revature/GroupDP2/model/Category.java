package com.revature.GroupDP2.model;

import org.json.JSONPropertyName;

import javax.persistence.*;

@Entity
@Table(name = "categories", schema = "groupd")
public class Category {
    @Id
    @Column(name = "category_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

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
