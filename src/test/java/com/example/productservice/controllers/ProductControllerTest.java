package com.example.productservice.controllers;

import com.example.productservice.exceptions.ProductNotFoundException;
import com.example.productservice.models.Product;
import com.example.productservice.services.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    ProductService productService;

    @Test
    void whenIDProvidesReturnProduct() throws ProductNotFoundException {
        // Arrange
        Long id = 2L;

        Product p=new Product();
        p.setId(2L);
        p.setTitle("Test product");

        Mockito.when(productService.getProductByID(2L)).thenReturn(p);

        // Act
        Product product=productController.getproductByID(id).getBody();
        // Assert
        Assertions.assertEquals("Test product", product.getTitle());
        Assertions.assertEquals(2L, product.getId());

    }
    @Test
    void ProductNotFoundExpection() throws ProductNotFoundException {
        // Arrange
        Long id = 2L;
        Product p=new Product();
        p.setId(2L);
        p.setTitle("Test product");

        Mockito.when(productService.getProductByID(2L)).thenThrow(ProductNotFoundException.class);

        // Act & Assert
        Assertions.assertThrows(ProductNotFoundException.class,()->productController.getproductByID(id).getBody());

    }

}