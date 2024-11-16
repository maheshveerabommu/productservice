package com.example.productservice.repos;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findAllById(Long id);
    List<Product> findAll();

}
