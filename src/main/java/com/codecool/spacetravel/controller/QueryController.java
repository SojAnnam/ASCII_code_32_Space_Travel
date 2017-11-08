package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.SolarSystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.*;

public class QueryController {
    public static List getPlanetsBySolarSystemId(long id, EntityManager em) {

        List<Planet> listOfPlanetsBySolarSystem = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();

        return listOfPlanetsBySolarSystem;
    }
    public static List getSolarSystem(EntityManager em){

        List<SolarSystem> listOfSolarSystem = em.createNamedQuery("SolarSystem.getSolarSystem", SolarSystem.class)
                .getResultList();

        return listOfSolarSystem;

    }

    public static List<Planet> getAllPlanet(EntityManager em){

        List<Planet> listOfAllPlanets = em.createNamedQuery("Planet.getAllPlanet", Planet.class)
                .getResultList();

        return listOfAllPlanets;

    }
}
