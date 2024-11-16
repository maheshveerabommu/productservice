package com.example.productservice.models;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Product extends BaseModel{
    String description;
    double price;
    @ManyToOne
    Category category;
//    @ManyToMany(mappedBy = "productlist")
//    List<Category> categories;
    int qty;
}
