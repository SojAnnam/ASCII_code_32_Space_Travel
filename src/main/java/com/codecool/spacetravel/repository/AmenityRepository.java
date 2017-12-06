package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.AmenityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AmenityRepository extends JpaRepository<AmenityType, Long> {
}
