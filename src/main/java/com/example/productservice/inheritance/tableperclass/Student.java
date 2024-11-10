package com.example.productservice.inheritance.tableperclass;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_student")
public class Student extends User {
    String course;
    String batch;
}