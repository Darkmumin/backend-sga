package com.jai.darkmumin.sga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jai.darkmumin.sga.models.Asset;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

} 
