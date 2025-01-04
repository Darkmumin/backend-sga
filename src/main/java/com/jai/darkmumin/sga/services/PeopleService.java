package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.jai.darkmumin.sga.models.People;
import com.jai.darkmumin.sga.repository.PeopleRepository;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }
    // Is the method service CRUD for People
    public Page<People> getPeople(Pageable pageable) {
        return peopleRepository.findAll(pageable);
    }
    public People obtainPeopleById(Long id) {
        return peopleRepository.findById(id).get();
    }
    public People savePeople(People person) {
        return peopleRepository.save(person);
    }
    public void deletePeople(Long id) {
        peopleRepository.deleteById(id);
    }
    public People updatePeople(People person) {
        return peopleRepository.save(person);
    }
}