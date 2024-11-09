package com.example.productservice.controllers;

import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productservice;

    public ProductController(ProductService productservice) {
        this.productservice = productservice;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductByID(@PathVariable("id") Long id) throws InstanceNotFoundException {
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

    @ExceptionHandler(InstanceNotFoundException.class)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
}
