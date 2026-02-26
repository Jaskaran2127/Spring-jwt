package com.example.jwt.service;

import com.example.jwt.Enums.AttributeType;
import com.example.jwt.dto.ProductRequestDto;
import com.example.jwt.entity.Attribute;
import com.example.jwt.entity.Category;
import com.example.jwt.entity.Product;
import com.example.jwt.entity.SubCategory;
import com.example.jwt.repository.AttributeRepository;
import com.example.jwt.repository.CategoryRepository;
import com.example.jwt.repository.ProductRepository;
import com.example.jwt.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AttributeRepository attributeRepository;

    public Product createProductService(ProductRequestDto productRequestData) {

        Product newProduct = new Product();
        newProduct.setName(productRequestData.getName());
        newProduct.setPrice(productRequestData.getPrice());
        newProduct.setStock(productRequestData.getStock());

        Category category = categoryRepository
                .findById(productRequestData.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        newProduct.setCategory(category);

        SubCategory subCategory = null;

        if (productRequestData.getSubCategoryId() != null) {
            subCategory = subCategoryRepository
                    .findById(productRequestData.getSubCategoryId())
                    .orElseThrow(() -> new RuntimeException("SubCategory not found"));

            newProduct.setSubCategory(subCategory);
        }

        Map<String, String> incomingAttributes = productRequestData.getAttributes();
        if (incomingAttributes == null) {
            incomingAttributes = new HashMap<>();
        }

        List<Attribute> allowedAttributes;

        if (subCategory != null) {
            allowedAttributes = attributeRepository
                    .findBySubCategoryList_Id(productRequestData.getSubCategoryId());
        } else {
            allowedAttributes = attributeRepository
                    .findByCategory_Id(productRequestData.getCategoryId());
        }

        if (allowedAttributes.isEmpty()) {
            allowedAttributes = attributeRepository.findByCategory_Id(category.getId());
        }

        Map<String, Attribute> attributeMap = allowedAttributes.stream()
                .collect(Collectors.toMap(Attribute::getName, a -> a));

        Map<String, String> validatedAttributes = new HashMap<>();

        for (Map.Entry<String, String> entry : incomingAttributes.entrySet()) {

            String attrName = entry.getKey();
            String attrVal = entry.getValue();

            Attribute attribute = attributeMap.get(attrName);

            if (attribute == null) {
                throw new RuntimeException(attrName + " is not allowed for this category");
            }

            if (attribute.getType() == AttributeType.SELECT) {
                if (!attribute.getVal().contains(attrVal)) {
                    throw new RuntimeException(
                            "Invalid value for " + attrName +
                                    ". Allowed values: " + attribute.getVal()
                    );
                }
            }

            validatedAttributes.put(attrName, attrVal);
        }

        newProduct.setAttributes(validatedAttributes);

        return productRepository.save(newProduct);
    }

}
