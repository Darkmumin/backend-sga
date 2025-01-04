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

import com.jai.darkmumin.sga.models.People;
import com.jai.darkmumin.sga.services.PeopleService;

@RestController
@RequestMapping ("/api/v1/people")
public class PeopleController {
    private final PeopleService peopleService;
    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    // Is the method CRUD for People
    @GetMapping
    ResponseEntity <Page<People>> getPeople(Pageable pageable) {
        return new ResponseEntity<>(peopleService.getPeople(pageable), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity <People> obtainPeopleById(@PathVariable Long id) {
        return new ResponseEntity<>(peopleService.obtainPeopleById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <People> savePeople(@RequestBody People person) {
        peopleService.savePeople(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <People> deletePeople(@PathVariable Long id) {
        peopleService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping
    ResponseEntity <People> updatePeople(@RequestBody People person) {
        peopleService.updatePeople(person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
