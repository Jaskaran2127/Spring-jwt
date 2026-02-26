package com.example.jwt.service;

import com.example.jwt.Enums.AttributeType;
import com.example.jwt.dto.AttributeRequestDto;
import com.example.jwt.entity.Attribute;
import com.example.jwt.entity.Category;
import com.example.jwt.entity.SubCategory;
import com.example.jwt.repository.AttributeRepository;
import com.example.jwt.repository.CategoryRepository;
import com.example.jwt.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    public Attribute createAttributeService(AttributeRequestDto attributeRequestDto){

        Attribute newAttribute = new Attribute();

        if (attributeRepository.existsByNameIgnoreCase(attributeRequestDto.getName())) {
            throw new RuntimeException("Attribute already exists");
        }

        Category category= categoryRepository.findById(attributeRequestDto.getCategoryId()).orElseThrow(()-> new RuntimeException("Category not found"));

        newAttribute.setCategory(category);

        if(attributeRequestDto.getSubCategoryIds() != null &&
                !attributeRequestDto.getSubCategoryIds().isEmpty()){
            List<SubCategory> subCategoryList=subCategoryRepository.findAllById(attributeRequestDto.getSubCategoryIds());
            newAttribute.setSubCategoryList(subCategoryList);
        }

        newAttribute.setName(attributeRequestDto.getName());

        newAttribute.setType(attributeRequestDto.getType());

        if(attributeRequestDto.getType() ==  AttributeType.SELECT && !attributeRequestDto.getValues().isEmpty()){
            newAttribute.setVal(attributeRequestDto.getValues());
        }

        return attributeRepository.save(newAttribute);
    }
}
