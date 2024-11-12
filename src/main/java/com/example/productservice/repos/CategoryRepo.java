package com.example.productservice.repos;


import com.example.productservice.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findAllById(Long id);
}
