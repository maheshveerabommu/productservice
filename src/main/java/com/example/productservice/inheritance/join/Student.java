package com.example.productservice.inheritance.join;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_student")
public class Student extends User {
    String course;
    String batch;
}
