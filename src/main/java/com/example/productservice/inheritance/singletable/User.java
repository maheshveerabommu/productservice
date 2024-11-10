package com.example.productservice.inheritance.singletable;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Entity(name="st_user")
public class User {
    @Id
    Long id;
    String name;
    String email;
    String phone_number;
    String password;
}
