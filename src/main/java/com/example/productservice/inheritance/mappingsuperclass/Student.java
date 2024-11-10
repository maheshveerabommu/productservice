package com.example.productservice.inheritance.mappingsuperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_student")
public class Student extends User{
    String course;
    String batch;
}
