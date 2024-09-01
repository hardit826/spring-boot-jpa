package com.hardit_code.spring_boot_jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class Employee {

    // fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name= "email")
    private String email;

    // constructor

    // getter/setter

    // define toString

}
