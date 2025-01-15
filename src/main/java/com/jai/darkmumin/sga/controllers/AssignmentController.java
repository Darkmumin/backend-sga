package com.jai.darkmumin.sga.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.darkmumin.sga.models.Assignment;
import com.jai.darkmumin.sga.services.AssignmentService;

@RestController
@RequestMapping("/api/v1/assignment")
public class AssignmentController {
    private final AssignmentService assignmentService;
    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }
    // Is the method CRUD for Assignment
    @GetMapping
    ResponseEntity <Page<Assignment>> getAssignments(Pageable pageable) {
        return new ResponseEntity<>(assignmentService.getAssignments(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity <Assignment> obtainAssignmentById(@PathVariable Long id) {
        return new ResponseEntity<>(assignmentService.obtainAssignmentById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <Assignment> saveAssignment(@RequestBody Assignment assignment) {
        assignmentService.saveAssignment(assignment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <Assignment> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssignment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    ResponseEntity <Assignment> updateAssignment(@RequestBody Assignment assignment) {
        assignmentService.updateAssignment(assignment);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
