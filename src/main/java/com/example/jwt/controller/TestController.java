package com.example.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public ResponseEntity<String> getTestMapping(){
        return ResponseEntity.ok("Test");
    }

    @GetMapping("/test-two")
    public ResponseEntity<String> getTestTwoMapping(){
        return ResponseEntity.ok("Test2");
    }
}
