package com.example.productservice.inheritance.join;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name="jt_user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    Long id;
    String name;
    String email;
    String phone_number;
    String password;
}
