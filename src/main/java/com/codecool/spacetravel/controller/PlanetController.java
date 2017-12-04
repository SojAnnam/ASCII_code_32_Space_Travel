package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class PlanetController {


    PlanetDataHandler planetDataHandler;

    public PlanetController(PlanetDataHandler planetDataHandler) {
        this.planetDataHandler = planetDataHandler ;
    }

    public  ModelAndView renderPlanets(Request req, Response res, boolean newCustomerSaved) {

        Map params = planetDataHandler.collectPlanetData(req,newCustomerSaved);

        return new ModelAndView(params, "index");
    }
}
