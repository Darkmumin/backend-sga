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
@Table(name = "assignments_details")
public class AssignmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "assetId", nullable = false, unique = false)
    public long assetId;
    @Column(name = "assignmentId", nullable = false, unique = false)
    public long assignmentId;
    @Column(name = "status", nullable = false, unique = false)
    public Integer status;

    @ManyToOne
    @JoinColumn(name = "assetId", insertable = false, updatable = false)
    private Asset asset;

    @ManyToOne
    @JoinColumn(name = "assignmentId", insertable = false, updatable = false)
    private Assignment assignment;
}
