package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.AmenityType;
import com.codecool.spacetravel.model.Customer;
import org.eclipse.persistence.queries.JPAQueryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AmenityRepository extends JpaRepository<AmenityType, Long> {
    List<AmenityType> getAmenitiesByAccomodationId(@Param("id") Long id);

}
