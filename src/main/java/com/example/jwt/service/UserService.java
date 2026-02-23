package com.example.jwt.service;

import com.example.jwt.dto.UserRequestDTO;
import com.example.jwt.dto.UserResponseDTO;
import com.example.jwt.entity.CustomUserEntity;
import com.example.jwt.entity.User;
import com.example.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtService jwtService;


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

    public String handleLogin (UserRequestDTO userRequest){
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getEmail(), userRequest.getPassword()
                )
        );
        return jwtService.generateToken(new CustomUserEntity(userRequest.getEmail(),userRequest.getPassword(),userRequest.getRole()));
    }


}
