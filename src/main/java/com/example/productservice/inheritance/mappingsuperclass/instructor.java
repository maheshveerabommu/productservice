package com.example.productservice.inheritance.mappingsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_instructor")
public class instructor extends  User{
    String specialization;
}
