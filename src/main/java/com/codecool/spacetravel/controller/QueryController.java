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
        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();*/

        List<Planet> results = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();
        System.out.println("SIZE IN QueryController: " + results.size());

        /*em.close();
        emf.close();*/

        return results;
    }

    public static List getAllSolarSystem(EntityManager em) {
        List<SolarSystem> results =  em.createNamedQuery("SolarSystem.getAllSolarSystem", SolarSystem.class).getResultList();
        return results;
    }
}
