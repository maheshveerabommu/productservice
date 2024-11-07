package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }
    @GetMapping("/{id}")
    public Product getproductByID(@PathVariable("id") Long id){
        return productservice.getProductByID(id);

    }
}
