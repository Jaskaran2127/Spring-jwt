package com.example.jwt.service;

import com.example.jwt.dto.CategoryRequestDto;
import com.example.jwt.dto.SubCategoryRequestDto;
import com.example.jwt.entity.Category;
import com.example.jwt.entity.SubCategory;
import com.example.jwt.repository.CategoryRepository;
import com.example.jwt.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public SubCategory createSubCatgoryService(SubCategoryRequestDto subCategoryDto){
        if (subCategoryRepository.existsByNameIgnoreCase(subCategoryDto.getName())) {
            throw new RuntimeException("Sub Category already exists");
        }

        Category category=categoryRepository.findById(subCategoryDto.getCategoryId()).orElseThrow(()->new RuntimeException("Category not found"));

        SubCategory subCategory = new SubCategory();
        subCategory.setName(subCategoryDto.getName());
        subCategory.setCategory(category);

        return subCategoryRepository.save(subCategory);
    }

}
