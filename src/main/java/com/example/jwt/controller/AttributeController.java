package com.example.jwt.controller;

import com.example.jwt.dto.AttributeRequestDto;
import com.example.jwt.dto.CategoryRequestDto;
import com.example.jwt.entity.Attribute;
import com.example.jwt.entity.Category;
import com.example.jwt.service.AttributeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @PostMapping
    public ResponseEntity<Attribute> createCategory(@RequestBody @Valid AttributeRequestDto data){
        Attribute newAttribute=attributeService.createAttributeService(data);
        return ResponseEntity.ok(newAttribute);
    }

}
