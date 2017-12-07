package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.Accomodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccomodatiponRepository extends JpaRepository<Accomodation, Long> {

    List<Accomodation> getAccByPlanetId(@Param("planetId") long planetId);

    Accomodation getAccomodationById(@Param("accomodationId") long accomodationId);

}
