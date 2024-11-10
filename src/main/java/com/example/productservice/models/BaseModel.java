package com.example.productservice.models;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id
    Long id;
    String title;
}
