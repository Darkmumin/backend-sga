package com.jai.darkmumin.sga.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jai.darkmumin.sga.models.People;
import com.jai.darkmumin.sga.repository.PeopleRepository;

@RestController
@RequestMapping ("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepository;
    @GetMapping
    public List<People> GetPeople() {
        return peopleRepository.findAll();

    }
}
