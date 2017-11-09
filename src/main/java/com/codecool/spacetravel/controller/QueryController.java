package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Accomodation;
import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.SolarSystem;
import com.codecool.spacetravel.Model.Customer;
import com.codecool.spacetravel.Model.Room;
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

    public static List<Customer> getAllCustomers(EntityManager em) {
        List<Customer> results = em.createNamedQuery("Customer.getAllCustomers", Customer.class)
                .getResultList();
        return results;
    }

    public static List<Room> getRoomById(long roomId, EntityManager em) {
        List<Room> results = em.createNamedQuery("Room.getRoomById", Room.class)
                .setParameter("roomId", roomId).getResultList();
        return results;
    }

    public static List getAllSolarSystem(EntityManager em) {
        List<SolarSystem> results =  em.createNamedQuery("SolarSystem.getAllSolarSystem", SolarSystem.class).getResultList();
        return results;
    }
}
