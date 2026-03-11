package com.example.jwt.filter;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Component
public class CorsFilter implements CorsConfigurationSource {
   @Override
    public CorsConfiguration getCorsConfiguration(HttpServletRequest request){
       CorsConfiguration config= new CorsConfiguration();
       config.setAllowedOrigins(List.of("*"));
       config.setAllowedMethods(List.of("*"));
       config.setAllowedHeaders(List.of("*"));
       return config;
   }
}
