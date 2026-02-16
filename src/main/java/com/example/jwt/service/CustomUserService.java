package com.example.jwt.service;

import com.example.jwt.entity.CustomUserEntity;
import com.example.jwt.entity.User;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user=userRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("User Not Found"));

        return  new CustomUserEntity(user.getEmail(),user.getPassword(),user.getRole());
    }
}
