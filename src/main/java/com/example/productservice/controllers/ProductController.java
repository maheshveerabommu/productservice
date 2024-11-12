package com.example.productservice.controllers;

import com.example.productservice.dtos.ProductNotFoundExpectionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
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

    public ProductController(  ProductService productservice) {
        this.productservice = productservice;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getproductByID(@PathVariable("id") Long id) throws  ProductNotFoundException {
        Product product= productservice.getProductByID(id);
        ResponseEntity<Product> responseEntity;

//        if (product==null){
//            responseEntity=new ResponseEntity<>(HttpStatus.NOT_FOUND);
//            return responseEntity;
//        }
        responseEntity=new ResponseEntity<>(product,HttpStatus.OK);
        return responseEntity;

    }

    @GetMapping()
    public List<Product> getAllProducts(){ //hello2
        return productservice.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable("id") Long id, @RequestBody Product product){
        return productservice.replaceProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public String  deleteProduct(@PathVariable("id") Long id){

        productservice.deleteProduct(id);
        return "Product deleted successfully";
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product){
        return productservice.createProduct(product);
    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ProductNotFoundExpectionDto> handleProductNotFoundException(ProductNotFoundException e){
//        ProductNotFoundExpectionDto productNotFoundExceptiondto =new ProductNotFoundExpectionDto();
//        productNotFoundExceptiondto.setErrorCode(e.getId());
//        productNotFoundExceptiondto.setMessage(e.getMessage());
//        return new ResponseEntity<>(productNotFoundExceptiondto,HttpStatus.NOT_FOUND);
//    }
}
