package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.SolarSystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolarSystemRepository extends JpaRepository<SolarSystem, Long> {

    List<SolarSystem> getAllSolarSystem();

}
