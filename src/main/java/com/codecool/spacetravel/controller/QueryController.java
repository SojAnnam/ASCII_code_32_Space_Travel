package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Planet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

public class QueryController {
    public static List getPlanetsBySolarSystemId(int id) {

        System.out.println("itt van gáz");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        List<Planet> results = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();


        em.close();
        emf.close();

        return results;
    }
}
