package com.example.jwt.dto;

import com.example.jwt.Enums.AttributeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class AttributeRequestDto {
    public AttributeRequestDto(String name, AttributeType type, List<String> values, Long categoryId, List<Long> subCategoryIds) {
        this.name = name;
        this.type = type;
        this.values = values;
        this.categoryId = categoryId;
        this.subCategoryIds = subCategoryIds;
    }

    @NotBlank(message = "Attribute name is required")
    private String name;

    @NotNull(message = "Attribute type is required")
    private AttributeType type;

    // Optional → only needed when type = SELECT / MULTI_SELECT
    private List<String> values;

    @NotNull(message = "Category id is required")
    private Long categoryId;

    // Optional → attribute can belong to all subcategories of a category
    private List<Long> subCategoryIds;

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Long> getSubCategoryIds() {
        return subCategoryIds;
    }

    public void setSubCategoryIds(List<Long> subCategoryIds) {
        this.subCategoryIds = subCategoryIds;
    }
}