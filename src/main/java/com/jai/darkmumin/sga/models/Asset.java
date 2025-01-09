package com.jai.darkmumin.sga.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "assets")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "inventoryCode", nullable = false, unique = false)
    public String inventoryCode;
    @Column(name = "name", nullable = false, unique = false)
    public String name;
    @Column(name = "categoryId", nullable = false, unique = false)
    public long categoryId;
    @Column(name = "brand", nullable = false, unique = false)
    public String brand;
    @Column(name = "model", nullable = false, unique = false)
    public String model;
    @Column(name = "serialNumber", nullable = false, unique = true)
    public String serialNumber;
    @Column(name = "description", nullable = false, unique = false)
    public String description;
    @Column(name = "assignmentState", nullable = false, unique = false)
    public boolean assignmentState;

    @ManyToOne
    @JoinColumn(name = "categoryId", insertable = false, updatable = false)
    private Category category;
    public Category getCategory() {
        return category;
    }

}
