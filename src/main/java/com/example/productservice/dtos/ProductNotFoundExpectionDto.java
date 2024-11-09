package com.example.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundExpectionDto {
    private long errorCode;
    private String message;

}
