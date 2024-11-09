package com.example.productservice.services;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;

import java.util.List;


public interface ProductService {

    public Product getProductByID(Long id) throws  ProductNotFoundException;
    public List<Product> getAllProducts();
    public Product replaceProduct(Long id, Product product);
}
