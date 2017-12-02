package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class PlanetRegistrationController {

    PlanetDataHandler planetDataHandler;

    public PlanetRegistrationController(PlanetDataHandler planetDataHandler) {
        this.planetDataHandler= planetDataHandler;
    }

    public ModelAndView renderPlanetRegistration(Request req, Response res) {

        Map params = planetDataHandler.renderPlanetRegistration(req);


        return new ModelAndView(params, "registration_planet");
    }
}
