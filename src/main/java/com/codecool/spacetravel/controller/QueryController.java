package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Accomodation;
import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.Room;

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

    public static List<Room> getRoomsByAcommodationId(long acommodationId, EntityManager em) {
        List<Room> results = em.createNamedQuery("Room.getRoomsByAcommodationId", Room.class)
                .setParameter("acommodationId", acommodationId).getResultList();
        return results;
    }

    public static List<Accomodation> getAccomodationById(long acommodationId, EntityManager em) {
        List<Accomodation> results = em.createNamedQuery("Accomodation.getAccomodationById", Accomodation.class)
                .setParameter("accomodationId", acommodationId).getResultList();
        return results;
    }
}
