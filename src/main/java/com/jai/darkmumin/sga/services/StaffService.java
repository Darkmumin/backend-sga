package com.jai.darkmumin.sga.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.jai.darkmumin.sga.models.Staff;
import com.jai.darkmumin.sga.repository.StaffRepository;

@Service
public class StaffService {
    private final StaffRepository staffRepository;
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }
    // Is the method service CRUD for People
    public Page<Staff> getPeople(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }
    public Staff obtainPeopleById(Long id) {
        return staffRepository.findById(id).get();
    }
    public Staff savePeople(Staff person) {
        return staffRepository.save(person);
    }
    public void deletePeople(Long id) {
        staffRepository.deleteById(id);
    }
    public Staff updatePeople(Staff person) {
        return staffRepository.save(person);
    }
}