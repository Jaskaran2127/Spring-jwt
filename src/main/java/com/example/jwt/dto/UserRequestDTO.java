package com.example.jwt.dto;

import com.example.jwt.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class UserRequestDTO {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public UserRequestDTO() {
    }
    public UserRequestDTO(String email, String password , Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @Email(message = "Email is required")
    @NotNull
    private String email;

    private String password;

    private Role role;
}
