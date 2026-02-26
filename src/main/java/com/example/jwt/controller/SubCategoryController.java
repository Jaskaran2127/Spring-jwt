package com.example.jwt.controller;
import com.example.jwt.dto.SubCategoryRequestDto;
import com.example.jwt.entity.SubCategory;
import com.example.jwt.service.SubCategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sub")
public class SubCategoryController {
    @Autowired
    private SubCategoryService subCategoryService;

    @PostMapping
    public ResponseEntity<SubCategory> createCategory(@RequestBody @Valid SubCategoryRequestDto data){
        SubCategory newCat=subCategoryService.createSubCatgoryService(data);
        return ResponseEntity.ok(newCat);
    }
}
