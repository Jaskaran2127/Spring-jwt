package com.example.jwt.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy ="category",fetch = FetchType.LAZY)
    private List<SubCategory> subcategory_list;

    @OneToMany(fetch = FetchType.LAZY,mappedBy ="category")
    private List<Product> products_list;

    public Category(Long id, String name, List<SubCategory> subcategory_list, List<Product> products_list) {
        this.id = id;
        this.name = name;
        this.subcategory_list = subcategory_list;
        this.products_list = products_list;
    }

    public Category() {
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

    public List<SubCategory> getSubcategory_list() {
        return subcategory_list;
    }

    public void setSubcategory_list(List<SubCategory> subcategory_list) {
        this.subcategory_list = subcategory_list;
    }

    public List<Product> getProducts_list() {
        return products_list;
    }

    public void setProducts_list(List<Product> products_list) {
        this.products_list = products_list;
    }
}
