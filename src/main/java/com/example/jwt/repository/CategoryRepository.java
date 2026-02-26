package com.example.jwt.repository;

import com.example.jwt.entity.Category;
import com.example.jwt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {

    boolean existsByNameIgnoreCase(String name);
}
