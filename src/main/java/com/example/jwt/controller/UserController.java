package com.example.jwt.controller;

import com.example.jwt.dto.UserRequestDTO;
import com.example.jwt.dto.UserResponseDTO;
import com.example.jwt.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDTO> signup(@RequestBody @Valid UserRequestDTO userRequest){
        UserResponseDTO userResponse= userService.createUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }


}
