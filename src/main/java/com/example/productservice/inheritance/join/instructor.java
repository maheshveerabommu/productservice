package com.example.productservice.inheritance.join;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_instructor")
public class instructor extends User {
    String specialization;
}
