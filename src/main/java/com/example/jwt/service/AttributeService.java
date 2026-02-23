package com.example.jwt.service;

import com.example.jwt.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;
}
