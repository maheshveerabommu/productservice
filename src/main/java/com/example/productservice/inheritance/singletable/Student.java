package com.example.productservice.inheritance.singletable;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("1")
@Entity
public class Student extends User {
    String course;
    String batch;
}
