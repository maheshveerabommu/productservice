package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductByID(@PathVariable("id") Long id){
        Product product= productservice.getProductByID(id);
        ResponseEntity<Product> responseEntity;

        if (product==null){
            responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return responseEntity;
        }
        responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productservice.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productservice.replaceProduct(id, product);
    }
}
