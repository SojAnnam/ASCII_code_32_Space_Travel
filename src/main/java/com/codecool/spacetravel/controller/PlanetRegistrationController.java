package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.datahandler.QueryHandler;
import com.codecool.spacetravel.model.Picture;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;
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
