package com.jai.darkmumin.sga.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public long id;
    @Column(name = "dni", nullable = false, unique = true)
    public long dni;
    @Column(name = "name", nullable = false)
    public String name;
    @Column(name = "lastName", nullable = false)
    public String lastName;
    @Column(name = "email", nullable = false, unique = true)
    public String email;
    @Column(name = "phone", nullable = false)
    public String phone;
    @Column(name = "address", nullable = false)
    public String address;
    @Column(name = "city", nullable = false)
    public String city;    
}

