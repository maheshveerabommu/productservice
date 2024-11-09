package com.example.productservice.services;

import com.example.productservice.models.Product;

import javax.management.InstanceNotFoundException;
import java.util.List;


public interface ProductService {

    public Product getProductByID(Long id) throws InstanceNotFoundException;
    public List<Product> getAllProducts();
    public Product replaceProduct(Long id, Product product);
}
