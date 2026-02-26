package com.example.jwt.controller;

import com.example.jwt.dto.CategoryRequestDto;
import com.example.jwt.entity.Category;
import com.example.jwt.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody @Valid CategoryRequestDto data){
        Category newCat=categoryService.createCategoryService(data);
        return ResponseEntity.ok(newCat);
    }
}
