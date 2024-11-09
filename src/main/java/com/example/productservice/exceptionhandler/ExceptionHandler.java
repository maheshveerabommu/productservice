package com.example.productservice.exceptionhandler;

import com.example.productservice.dtos.ProductNotFoundExpectionDto;
import com.example.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ProductNotFoundExpectionDto> handleProductNotFoundException(ProductNotFoundException e){
        ProductNotFoundExpectionDto productNotFoundExceptiondto =new ProductNotFoundExpectionDto();
        productNotFoundExceptiondto.setErrorCode(e.getId());
        productNotFoundExceptiondto.setMessage(e.getMessage());
        return new ResponseEntity<>(productNotFoundExceptiondto, HttpStatus.NOT_FOUND);
    }
}
