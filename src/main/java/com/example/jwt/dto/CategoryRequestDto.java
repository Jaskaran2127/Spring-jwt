package com.example.jwt.dto;

import jakarta.validation.constraints.NotBlank;

public class CategoryRequestDto {
    @NotBlank(message = "Name is required")
    private String name;

    public CategoryRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
