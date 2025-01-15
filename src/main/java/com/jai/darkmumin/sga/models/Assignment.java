package com.jai.darkmumin.sga.models;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    @Column(name = "assignedDate", nullable = false, unique = false)
    public Date assignedDate;
    @Column(name = "staffId", nullable = false, unique = false)
    public long staffId;
    @Column(name = "userId", nullable = false, unique = false)
    public long userId;
    @Column(name = "observation", nullable = false, unique = false)
    public String observation;

    @ManyToOne
    @JoinColumn(name = "staffId", insertable = false, updatable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "assignment")
    private List<AssignmentDetail> assignmentDetails;

    public List<AssignmentDetail> getAssignmentDetails() {
        return assignmentDetails;
    }
    
}
