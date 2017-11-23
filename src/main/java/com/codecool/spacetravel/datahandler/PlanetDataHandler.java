package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class PlanetDataHandler implements PersistHandler {

    EntityManager em;

    public PlanetDataHandler(EntityManager em) {
        this.em = em;
    }

    public List getPlanetsBySolarSystemId(long id) {
        List<Planet> listOfPlanetsBySolarSystem = em.createNamedQuery("Planet.getPlanetsBySolarSystemId", Planet.class)
                .setParameter("solarSystemId", id).getResultList();

        return listOfPlanetsBySolarSystem;
    }

    public List getAllSolarSystem() {
        List<SolarSystem> results =  em.createNamedQuery("SolarSystem.getAllSolarSystem", SolarSystem.class).getResultList();
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

    @Override
    public void persistData(Object object) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(object);
        transaction.commit();
    }
}
