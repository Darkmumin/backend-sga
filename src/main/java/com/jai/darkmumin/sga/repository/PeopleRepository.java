package com.jai.darkmumin.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jai.darkmumin.sga.models.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
