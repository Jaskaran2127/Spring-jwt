package com.example.jwt.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;


    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="subCategory")
    private List<Product> products_list;

    public SubCategory(Long id, String name, Category category,List<Product> products) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.products_list=products;
    }

    public List<Product> getProducts_list() {
        return products_list;
    }

    public void setProducts_list(List<Product> products_list) {
        this.products_list = products_list;
    }

    public SubCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}