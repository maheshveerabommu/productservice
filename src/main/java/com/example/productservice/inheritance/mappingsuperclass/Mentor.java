package com.example.productservice.inheritance.mappingsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="msc_mentor")
public class Mentor extends User{
    String company;
    int avgRating;
}
