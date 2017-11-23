package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import spark.Request;


import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccDataHandler {

    private EntityManager em;
    private QueryHandler queryHandler;
    public AccDataHandler(EntityManager em, QueryHandler queryHandler) {

        this.em = em;
        this.queryHandler = queryHandler;
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

    public Map renderAccHandler (Request req, long planetId){
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        Planet planet = queryHandler.getPlanet(planetId);

        List<Accomodation> accList = queryHandler.getAccByPlanetId(planetId);
        //System.out.println("getPlanetsBySolarSystemId - controller");

        Map params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("loggedIn", customerId != null);
        params.put("accomodations", accList);
        params.put("planet", planet);

        return params;
    }

}

