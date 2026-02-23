package com.example.jwt.filter;

import com.example.jwt.entity.CustomUserEntity;
import com.example.jwt.service.CustomUserService;
import com.example.jwt.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtService jwtService;

    @Autowired
    private CustomUserService customUserService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException , IOException{
        String authHeader=request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer")){
            String token= authHeader.substring(7);
            String extractUsername= jwtService.extractUsername(token);
            if(extractUsername!= null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails customUser=customUserService.loadUserByUsername(extractUsername);
                UsernamePasswordAuthenticationToken authToken= new UsernamePasswordAuthenticationToken(customUser,null,customUser.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        chain.doFilter(request, response);
    }
}
