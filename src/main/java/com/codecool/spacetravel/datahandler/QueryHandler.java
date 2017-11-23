package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.*;

import javax.persistence.EntityManager;
import java.util.List;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.Room;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;


public class QueryHandler implements PersistHandler{

    EntityManager em;

    public QueryHandler(EntityManager em) {
        this.em = em;
    }

    public List getPlanetsBySolarSystemId(long id) {

        List<Planet> listOfPlanetsBySolarSystem = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();

        return listOfPlanetsBySolarSystem;
    }

    public  List getAccByPlanetId(long id){

        List<Accomodation> results = em.createNamedQuery("getAccByPlanetId", Accomodation.class)
                .setParameter("planetId", id).getResultList();

        return results;
    }

    public  List<Planet> getAllPlanet(){

        List<Planet> listOfAllPlanets = em.createNamedQuery("Planet.getAllPlanet", Planet.class)
                .getResultList();

        return listOfAllPlanets;

    }

    public Planet getPlanet(long planetId){

        Planet planet = em.createNamedQuery("getPlanet", Planet.class)
                .setParameter("planetId", planetId).getSingleResult();

        return planet;
    }


    public  List<Customer> getAllCustomers() {
        List<Customer> results = em.createNamedQuery("Customer.getAllCustomers", Customer.class)
                .getResultList();
        return results;
    }

    public  List getAllSolarSystem() {
        List<SolarSystem> results =  em.createNamedQuery("SolarSystem.getAllSolarSystem", SolarSystem.class).getResultList();
        return results;
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        try{
            customer = em.createNamedQuery("Customer.getCustomerByEmail", Customer.class)
                    .setParameter("email", email).getSingleResult();
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    public List<Room> getRoomsByAcommodationId(long acommodationId) {
        List<Room> results = em.createNamedQuery("Room.getRoomsByAcommodationId", Room.class)
                .setParameter("acommodationId", acommodationId).getResultList();
        return results;
    }

    public Accomodation getAccomodationById(long acommodationId) {
        Accomodation accomodation = null;
        try {
            accomodation = em.createNamedQuery("Accomodation.getAccomodationById", Accomodation.class)
                    .setParameter("accomodationId", acommodationId).getSingleResult();

        } catch (Exception e){
            System.out.println("No accomodation.");
        }
        return accomodation;
    }

    public Room getRoomById(long roomId) {
        Room room = null;
        try {
            room = em.createNamedQuery("Room.getRoomById", Room.class)
                    .setParameter("roomId", roomId).getSingleResult();
        } catch (Exception e){
            System.out.println("No room.");
        }
        return room;
    }

    public Customer getCustomerById(Long customerId) {
        Customer customer = null;
        try{
            customer = em.createNamedQuery("Customer.getCustomerById", Customer.class)
                    .setParameter("id", customerId).getSingleResult();
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    @Override
    public void persistData(Object object) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(object);
        transaction.commit();
    }
}

