package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.AmenityType;
import com.codecool.spacetravel.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface AmenityRepository  extends JpaRepository<AmenityType, Long> {
    @Query(value = "SELECT * FROM amenitytype at " +
            "JOIN accomodation_amenity_types aat ON aat.amenity_types_id = at.id " +
            "WHERE aat.accomodations_id = ?1",
            nativeQuery = true)
    List<AmenityType> getAmenityTypesBy(long accomodationId);
}
