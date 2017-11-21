package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Picture;
import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.SolarSystem;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationController {

    public static ModelAndView renderPlanetRegistration(Request req, Response res, EntityManager em) {

        Integer userId = req.session().attribute("user_id");

        List<SolarSystem> solarSystems = QueryController.getAllSolarSystem(em);

        String name = req.queryParams("name");
        String description = req.queryParams("desc");
        String weather = req.queryParams("weather");

        if (name != null && description != null  && weather != null) {
            if (!name.equals("") && !description.equals("")  && !weather.equals("")) {
                Picture pictureDefault = new Picture("default-planet.jpg","default-text", "default-title");
                SolarSystem currentSolarSystem = null;
                long galaxyIdLong = Long.parseLong(req.queryParams("galaxy"));
                for (SolarSystem solarSystem : SolarSystem.solarSystemList) {
                    if (solarSystem.getId() == galaxyIdLong) {
                        currentSolarSystem = solarSystem;
                    }
                }
                Planet currentPlanet = new Planet(name, description, weather, currentSolarSystem);
                currentPlanet.setPicture(pictureDefault);
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(pictureDefault);
                em.persist(currentPlanet);
                transaction.commit();
            }
        }

        Map params = new HashMap<>();
        params.put("loggedIn", userId != null);
        params.put("solarsystems", solarSystems);

        return new ModelAndView(params, "registration_planet");
    }
}
