package com.example.productservice.inheritance.join;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_mentor")
public class Mentor extends User {
    String company;
    int avgRating;
}
