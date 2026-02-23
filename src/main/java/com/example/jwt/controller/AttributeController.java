package com.example.jwt.controller;

import com.example.jwt.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

}
