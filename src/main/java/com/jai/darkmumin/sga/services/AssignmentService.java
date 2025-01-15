package com.jai.darkmumin.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.jai.darkmumin.sga.models.Assignment;
import com.jai.darkmumin.sga.models.AssignmentDetail;
import com.jai.darkmumin.sga.repository.AssignmentDetailRepository;
import com.jai.darkmumin.sga.repository.AssignmentRepository;

@Service

public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final AssignmentDetailRepository assignmentDetailRepository;
    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, AssignmentDetailRepository assignmentDetailRepository) {
        this.assignmentRepository = assignmentRepository;
        this.assignmentDetailRepository = assignmentDetailRepository;
    }
    
    
    public Page<Assignment> getAssignments(Pageable pageable) {
        return assignmentRepository.findAll(pageable);
    }

    public Assignment obtainAssignmentById(Long id) {
        return assignmentRepository.findById(id).get();
    }

    public Assignment saveAssignment(Assignment assignment) {
        Assignment savedAssignment = assignmentRepository.save(assignment);
        List<AssignmentDetail> listDetail = assignment.getAssignmentDetails();
        for (AssignmentDetail assignmentDetail : listDetail) {
            assignmentDetail.assignmentId = savedAssignment.id;
            assignmentDetailRepository.save(assignmentDetail);   
        }
        return savedAssignment;
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    public void updateAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }
}
