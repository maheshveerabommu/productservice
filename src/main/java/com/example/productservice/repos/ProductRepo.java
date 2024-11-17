package com.example.productservice.repos;

import com.example.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Product findAllById(Long id);
    List<Product> findAll();

    @Override
    void deleteById(Long id);

    //    @Query("DELETE FROM Product p where p.id = :id RETURNING p")
//    Product deleteByIdAndReturn(Long id);
}
