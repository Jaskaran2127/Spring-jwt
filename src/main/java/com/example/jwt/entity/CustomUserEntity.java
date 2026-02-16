package com.example.jwt.entity;

import com.example.jwt.Enums.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomUserEntity implements UserDetails {

    private String  username;

    private String password;

    private Role role;

    public CustomUserEntity(String username,String password,Role role){
        this.username=username;
        this.password=password;
        this.role=role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(
                new SimpleGrantedAuthority("ROLE_" + role.name())
        );
    }
}
