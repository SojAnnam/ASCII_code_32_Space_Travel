package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.datahandler.QueryHandler;
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
        this.planetDataHandler = planetDataHandler ;
    }

    public  ModelAndView renderPlanets(Request req, Response res, boolean newCustomerSaved) {

        Map params = planetDataHandler.renderPlanetHandler(req,newCustomerSaved);

        return new ModelAndView(params, "index");
    }
}
