package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Accomodation;
import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.SolarSystem;

import javax.persistence.*;
import java.util.*;

public class QueryController {
    public static List getPlanetsBySolarSystemId(long id, EntityManager em) {

        List<Planet> listOfPlanetsBySolarSystem = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();

        return listOfPlanetsBySolarSystem;
    }
    public static List getSolarSystem(EntityManager em) {

        List<SolarSystem> listOfSolarSystem = em.createNamedQuery("SolarSystem.getSolarSystem", SolarSystem.class)
                .getResultList();

        return listOfSolarSystem;
    }

    public static List getAccByPlanetId(long id, EntityManager em){

        List<Accomodation> results = em.createNamedQuery("getAccByPlanetId", Accomodation.class)
                .setParameter("planetId", id).getResultList();
        System.out.println("SIZE IN QueryController: " + results.size());

        return results;
    }

    public static List<Planet> getAllPlanet(EntityManager em){

        List<Planet> listOfAllPlanets = em.createNamedQuery("Planet.getAllPlanet", Planet.class)
                .getResultList();

        return listOfAllPlanets;

    }

    public static Planet getPlanet(long planetId, EntityManager em){

        Planet planet = em.createNamedQuery("getPlanet", Planet.class)
                .setParameter("planetId", planetId).getSingleResult();

        return planet;
    }
}
