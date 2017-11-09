package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.SolarSystem;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetController {

    public static ModelAndView renderPlanets(Request req, Response res, EntityManager em) {
        long solarSystemId = 1;

        if (req.params("solarSystemId")!=null){
            solarSystemId = Integer.parseInt(req.params(":solarSystemId"));
        }

        List<SolarSystem> solarSystemsList = QueryController.getAllSolarSystem(em);
        List<Planet> planetListBySolarSystem = QueryController.getPlanetsBySolarSystemId(solarSystemId, em);
        List<Planet> allPlanet = QueryController.getAllPlanet(em);

        Map params = new HashMap<>();
        params.put("solarsystems",solarSystemsList);
        params.put("planets", planetListBySolarSystem);
        params.put("allplanet",allPlanet);
        return new ModelAndView(params, "index");
    }
}
