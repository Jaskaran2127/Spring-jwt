package com.example.jwt.dto;

import com.example.jwt.Enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
public class UserResponseDTO {

    private Long id;

    private String email;

    private Role role;


    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String email , Role role) {
        this.id = id;
        this.email = email;
        this.role=role;
    }

}
