package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetController {


    PlanetDataHandler planetDataHandler;

    public PlanetController(PlanetDataHandler planetDataHandler) {
        this.planetDataHandler = planetDataHandler;
    }

    public  ModelAndView renderPlanets(Request req, Response res, EntityManager em, boolean newCustomerSaved) {
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        long solarSystemId = 1;

        if (req.params("solarSystemId")!=null){
            solarSystemId = Integer.parseInt(req.params(":solarSystemId"));
        }

        List<SolarSystem> solarSystemsList = planetDataHandler.getAllSolarSystem(em);
        List<Planet> planetListBySolarSystem = planetDataHandler.getPlanetsBySolarSystemId(solarSystemId, em);
        List<Planet> allPlanet = planetDataHandler.getAllPlanet(em);

        Map params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("solarsystems",solarSystemsList);
        params.put("planets", planetListBySolarSystem);
        params.put("allplanet",allPlanet);
        params.put("newcustomersaved", newCustomerSaved);
        return new ModelAndView(params, "index");
    }
}
