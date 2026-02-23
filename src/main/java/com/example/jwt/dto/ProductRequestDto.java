package com.example.jwt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

public class ProductRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Price is required")
    private int price;

    @NotNull(message = "Stock is required")
    private int stock;

    @NotNull(message = "Category is required")
    private Long categoryId;

    @NotNull(message = "SubCategory is required")
    private Long subCategoryId;

    private Map<String,String>attributes;

    public ProductRequestDto(String name, int price, int stock, Long categoryId, Long subCategoryId, Map<String, String> attributes) {
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.categoryId = categoryId;
        this.subCategoryId = subCategoryId;
        this.attributes = attributes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

}
