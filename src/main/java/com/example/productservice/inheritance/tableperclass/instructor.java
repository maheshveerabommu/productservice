package com.example.productservice.inheritance.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="tpc_instructor")
public class instructor extends User {
    String specialization;
}