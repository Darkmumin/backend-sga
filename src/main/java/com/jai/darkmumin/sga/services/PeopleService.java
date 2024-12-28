package com.jai.darkmumin.sga.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jai.darkmumin.sga.models.People;
import com.jai.darkmumin.sga.repository.PeopleRepository;

@Service
public class PeopleService {
    @Autowired
    PeopleRepository PeopleRepository;
    public List<People> getPeople() {
        return PeopleRepository.findAll();
    }
    public People obtainPeopleById(Long id) {
        return PeopleRepository.findById(id).get();
    }
}
