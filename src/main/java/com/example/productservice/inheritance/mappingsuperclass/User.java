package com.example.productservice.inheritance.mappingsuperclass;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class User {
    @Id
    Long id;
    String name;
    String email;
    String phone_number;
    String password;
}
