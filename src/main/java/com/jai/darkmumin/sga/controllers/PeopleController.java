package com.jai.darkmumin.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private PeopleService peoplesService;

    @GetMapping
    ResponseEntity <List<People>> getPeople() {
        return new ResponseEntity<>(peoplesService.getPeople(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    ResponseEntity <People> obtainPeopleById(@PathVariable Long id) {
        return new ResponseEntity<>(peoplesService.obtainPeopleById(id), HttpStatus.OK);
    }
    @PostMapping
    ResponseEntity <People> savePeople(@RequestBody People person) {
        peoplesService.savePeople(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("/{id}")
    ResponseEntity <People> deletePeople(@PathVariable Long id) {
        peoplesService.deletePeople(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    ResponseEntity <People> updatePeople(@PathVariable Long id, @RequestBody People person) {
        peoplesService.updatePeople(id, person);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
