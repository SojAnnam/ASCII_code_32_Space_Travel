package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.PlanetDataHandler;
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
        this.planetDataHandler = planetDataHandler;
    }

    public ModelAndView renderPlanetRegistration(Request req, Response res) {

        Integer userId = req.session().attribute("user_id");

        List<SolarSystem> solarSystems = planetDataHandler.getAllSolarSystem();

        String name = req.queryParams("name");
        String description = req.queryParams("desc");
        String weather = req.queryParams("weather");

        if (name != null && description != null  && weather != null) {
            if (!name.equals("") && !description.equals("")  && !weather.equals("")) {
                Picture pictureDefault = new Picture("default-planet.jpg","default-text", "default-title");
                SolarSystem currentSolarSystem = null;
                long galaxyIdLong = Long.parseLong(req.queryParams("galaxy"));

                for (SolarSystem solarSystem : solarSystems) {
                    if (solarSystem.getId() == galaxyIdLong) {
                        currentSolarSystem = solarSystem;
                    }
                }
                Planet currentPlanet = new Planet(name, description, weather, currentSolarSystem);
                currentPlanet.setPicture(pictureDefault);
                /*EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(pictureDefault);
                em.persist(currentPlanet);
                transaction.commit();*/
            }
        }

        Map params = new HashMap<>();
        params.put("loggedIn", userId != null);
        params.put("solarsystems", solarSystems);

        return new ModelAndView(params, "registration_planet");
    }
}
