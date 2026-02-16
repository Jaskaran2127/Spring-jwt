package com.example.jwt.dto;

import com.example.jwt.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
public class UserRequestDTO {

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
