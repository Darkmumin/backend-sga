package com.jai.darkmumin.sga.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public long dni;
    public String name;
    public String lastName;
    public String email;
    public String phone;
    public String address;
    public String city;

}

