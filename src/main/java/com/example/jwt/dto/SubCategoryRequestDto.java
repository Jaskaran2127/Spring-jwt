package com.example.jwt.dto;

import com.example.jwt.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class SubCategoryRequestDto {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Category Id Is missing")
    private Long categoryId;


    public SubCategoryRequestDto(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
