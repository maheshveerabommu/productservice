package com.example.productservice.inheritance.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DiscriminatorValue("2")
@Entity
public class Mentor extends User {
    String company;
    int avgRating;
}
