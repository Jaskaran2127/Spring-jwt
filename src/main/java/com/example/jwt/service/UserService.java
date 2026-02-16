package com.example.jwt.service;

import com.example.jwt.dto.UserRequestDTO;
import com.example.jwt.dto.UserResponseDTO;
import com.example.jwt.entity.User;
import com.example.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO createUser ( UserRequestDTO userData){
        if (userRepository.findByEmail(userData.getEmail()).isPresent()){
            throw new RuntimeException("User already exists with this email");
        }

        User user = new User();
        user.setEmail(userData.getEmail());
        user.setPassword(passwordEncoder.encode(userData.getPassword()));
        user.setRole(userData.getRole());

        User savedUser = userRepository.save(user);

        return new UserResponseDTO(
                savedUser.getId(),
                savedUser.getEmail(),
                savedUser.getRole()
        );
    }

}
