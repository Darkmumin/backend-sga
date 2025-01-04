package com.jai.darkmumin.sga.repository;

import org.springframework.stereotype.Repository;
import com.jai.darkmumin.sga.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    
}