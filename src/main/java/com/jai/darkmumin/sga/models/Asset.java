package com.jai.darkmumin.sga.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public long inventoryCode;
    public String name;
    public long categoryId;
    public String brand;
    public String model;
    public String serialNumber;
    public String description;

}
