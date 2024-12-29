package com.jai.darkmumin.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    public List<People> GetPeople() {
        return peoplesService.getPeople();
    }
    @GetMapping("/{id}")
    public People obtainPeopleById(@PathVariable Long id) {
        return peoplesService.obtainPeopleById(id);
    }
    @PostMapping
    ResponseEntity <People> savePeople(@RequestBody People person) {
        peoplesService.savePeople(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
