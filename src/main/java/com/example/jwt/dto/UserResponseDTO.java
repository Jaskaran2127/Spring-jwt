package com.example.jwt.dto;

import com.example.jwt.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Builder
public class UserResponseDTO {

    private Long id;

    private String email;

    private Role role;


    public UserResponseDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserResponseDTO(Long id, String email , Role role) {
        this.id = id;
        this.email = email;
        this.role=role;
    }

}
