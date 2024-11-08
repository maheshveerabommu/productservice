package com.example.productservice.services;

import com.example.productservice.models.Product;

import java.util.List;


public interface ProductService {

    public Product getProductByID(Long id);
    public List<Product> getAllProducts();
}
