package com.example.jwt.controller;

import com.example.jwt.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;
}
