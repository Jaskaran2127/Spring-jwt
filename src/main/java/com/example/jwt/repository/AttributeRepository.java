package com.example.jwt.repository;

import com.example.jwt.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute,Long> {

    boolean existsByNameIgnoreCase(String name);

    List<Attribute> findBySubCategoryList_Id(Long subCategoryId);

    List<Attribute> findByCategory_Id(Long categoryId);

}
