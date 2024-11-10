package com.example.productservice.inheritance.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name="tpc_user")
public class User {
    @Id
    Long id;
    String name;
    String email;
    String phone_number;
    String password;
}
