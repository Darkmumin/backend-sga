package com.jai.darkmumin.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jai.darkmumin.sga.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
