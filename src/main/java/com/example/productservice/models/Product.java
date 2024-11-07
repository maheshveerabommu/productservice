package com.example.productservice.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    long id;
    String title;
    String description;
    double price;
    Category category;
}
