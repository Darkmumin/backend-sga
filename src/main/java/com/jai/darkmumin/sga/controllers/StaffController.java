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

import com.jai.darkmumin.sga.models.Staff;
import com.jai.darkmumin.sga.services.StaffService;

@RestController
@RequestMapping ("/api/v1/staff")
public class StaffController {
    private final StaffService staffService;
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    // Is the method CRUD for People
    @GetMapping
    ResponseEntity <Page<Staff>> getPeople(Pageable pageable) {
        return new ResponseEntity<>(staffService.getPeople(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity <Staff> obtainPeopleById(@PathVariable Long id) {
        return new ResponseEntity<>(staffService.obtainPeopleById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <Staff> savePeople(@RequestBody Staff person) {
        staffService.savePeople(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <Staff> deletePeople(@PathVariable Long id) {
        staffService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    ResponseEntity <Staff> updatePeople(@RequestBody Staff person) {
        staffService.updatePeople(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
