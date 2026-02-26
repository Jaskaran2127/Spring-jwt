package com.example.jwt.controller;

import com.example.jwt.dto.ProductRequestDto;
import com.example.jwt.dto.SubCategoryRequestDto;
import com.example.jwt.entity.Product;
import com.example.jwt.entity.SubCategory;
import com.example.jwt.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequestDto data){
        Product newCat=productService.createProductService(data);
        return ResponseEntity.ok(newCat);
    }
}
