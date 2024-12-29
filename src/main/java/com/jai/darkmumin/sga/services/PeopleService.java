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
    public People savePeople(People person) {
        return PeopleRepository.save(person);
    }
    public void deletePeople(Long id) {
        PeopleRepository.deleteById(id);
    }
    public People updatePeople(Long id, People person) {
        People personToUpdate = PeopleRepository.findById(id).get() ;   
        personToUpdate.name = person.name;
        personToUpdate.lastName = person.lastName;
        personToUpdate.phone = person.phone;
        personToUpdate.email = person.email;
        return PeopleRepository.save(personToUpdate);
    }
}
