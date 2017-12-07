package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.AmenityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AmenityRepository  extends JpaRepository<AmenityType, Long> {
    List<AmenityType> getAmenityTypesBy(@Param("accomodationId") long accomodationId);
}
