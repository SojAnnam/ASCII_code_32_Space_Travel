package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.AccDataHandler;
import com.codecool.spacetravel.Model.Accomodation;
import com.codecool.spacetravel.Model.Planet;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccController {

    private AccDataHandler accDataHandler;

    public AccController(AccDataHandler accDataHandler) {
        this.accDataHandler = accDataHandler;
    }

    public ModelAndView renderAcc(Request req, Response res, long planetId) {

        Planet planet = accDataHandler.getPlanet(planetId);

        List<Accomodation> accList = accDataHandler.getAccByPlanetId(planetId);
        //System.out.println("getPlanetsBySolarSystemId - controller");

        Map params = new HashMap<>();
        params.put("accomodations", accList);
        params.put("planet", planet);
        return new ModelAndView(params, "accomodation");
    }
}
