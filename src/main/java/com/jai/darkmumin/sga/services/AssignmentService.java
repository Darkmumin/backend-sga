package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jai.darkmumin.sga.models.Assignment;
import com.jai.darkmumin.sga.repository.AssignmentRepository;

@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public Page<Assignment> getAssignments(Pageable pageable) {
        return assignmentRepository.findAll(pageable);
    }

    public Assignment obtainAssignmentById(Long id) {
        return assignmentRepository.findById(id).get();
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteAssignment(Long id) {
        assignmentRepository.deleteById(id);
    }

    public void updateAssignment(Assignment assignment) {
        assignmentRepository.save(assignment);
    }
}
