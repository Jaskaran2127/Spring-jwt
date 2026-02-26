package com.example.jwt.service;

import com.example.jwt.dto.CategoryRequestDto;
import com.example.jwt.entity.Category;
import com.example.jwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategoryService(CategoryRequestDto categoryDto){
        if (categoryRepository.existsByNameIgnoreCase(categoryDto.getName())) {
            throw new RuntimeException("Category already exists");
        }

        Category category = new Category();
        category.setName(categoryDto.getName());

        return categoryRepository.save(category);
    }

}
