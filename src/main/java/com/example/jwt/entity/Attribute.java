package com.example.jwt.entity;

import com.example.jwt.Enums.AttributeType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private AttributeType type;

    private List<String> val;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;

    @ManyToMany
    @JoinTable(name = "attribute_subcategory",joinColumns = @JoinColumn(name = "attribute_id"), inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private List<SubCategory> subCategoryList;

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public List<String> getVal() {
        return val;
    }

    public void setVal(List<String> val) {
        this.val = val;
    }

    public Attribute(Long id, String name, Category category, List<SubCategory> subCategoryList, List<String> val, AttributeType type) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.subCategoryList = subCategoryList;
        this.type = type;
        this.val = val;
    }


    public Attribute() {
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

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
