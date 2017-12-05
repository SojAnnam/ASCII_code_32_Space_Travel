package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlanetRepository extends JpaRepository<Planet, Long> {

    Planet getPlanet(@Param("planetId") long planetId);

    List<Planet> getPlanetsBySolarSystemId(@Param("solarSystemId") long id);

    List<Planet> getAllPlanet();
}
