package com.example.productservice.models;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@JsonSerialize
public class Product extends BaseModel implements Serializable {
    String description;
    double price;
    @ManyToOne
    Category category;
//    @ManyToMany(mappedBy = "productlist")
//    List<Category> categories;
//    int qty;
//    int stock;
}
