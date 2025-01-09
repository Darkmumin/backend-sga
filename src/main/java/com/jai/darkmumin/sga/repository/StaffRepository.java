package com.jai.darkmumin.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jai.darkmumin.sga.models.Staff;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

}
