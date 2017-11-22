package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.AccDataHandler;
import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccController {


    private PlanetDataHandler planetDataHandler;
    private AccDataHandler accDataHandler;

    public AccController(PlanetDataHandler planetDataHandler, AccDataHandler accDataHandler) {
        this.planetDataHandler = planetDataHandler;
        this.accDataHandler = accDataHandler;
    }

    public ModelAndView renderAcc(Request req, Response res, long planetId, EntityManager em) {

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        Planet planet = planetDataHandler.getPlanet(planetId);

        List<Accomodation> accList = accDataHandler.getAccByPlanetId(planetId);
        //System.out.println("getPlanetsBySolarSystemId - controller");

        Map params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("loggedIn", customerId != null);
        params.put("accomodations", accList);
        params.put("planet", planet);
        return new ModelAndView(params, "accomodation");
    }
}
