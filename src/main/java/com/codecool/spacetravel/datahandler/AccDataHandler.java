package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;

import javax.persistence.EntityManager;
import java.util.List;

public class AccDataHandler {

    private EntityManager em;
    public AccDataHandler(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public  List getAccByPlanetId(long id){

        List<Accomodation> results = em.createNamedQuery("getAccByPlanetId", Accomodation.class)
                .setParameter("planetId", id).getResultList();

        return results;
    }

    public Planet getPlanet(long planetId){

        Planet planet = em.createNamedQuery("getPlanet", Planet.class)
                .setParameter("planetId", planetId).getSingleResult();

        return planet;
    }

}

