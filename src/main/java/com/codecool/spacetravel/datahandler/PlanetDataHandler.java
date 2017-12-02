package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.PlanetPicture;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;
import spark.Request;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanetDataHandler{


    QueryHandler queryHandler;

    public PlanetDataHandler(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    public Map renderPlanetHandler (Request req, boolean newCustomerSaved){
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        long solarSystemId = 1;

        if (req.params("solarSystemId")!=null){
            solarSystemId = Integer.parseInt(req.params(":solarSystemId"));
        }

        List<SolarSystem> solarSystemsList = queryHandler.getAllSolarSystem();
        List<Planet> planetListBySolarSystem = queryHandler.getPlanetsBySolarSystemId(solarSystemId);
        List<Planet> allPlanet = queryHandler.getAllPlanet();

        Map params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("solarsystems",solarSystemsList);
        params.put("planets", planetListBySolarSystem);
        params.put("allplanet",allPlanet);
        params.put("newcustomersaved", newCustomerSaved);

        return params;
    }

    public Map renderPlanetRegistration(Request req) {
        Integer userId = req.session().attribute("user_id");

        List<SolarSystem> solarSystems = queryHandler.getAllSolarSystem();

        String name = req.queryParams("name");
        String description = req.queryParams("desc");
        String weather = req.queryParams("weather");

        if (name != null && description != null  && weather != null) {
            if (!name.equals("") && !description.equals("")  && !weather.equals("")) {
                PlanetPicture planetPictureDefault = new PlanetPicture("default-planet.jpg","default-text", "default-title");
                SolarSystem currentSolarSystem = null;
                long galaxyIdLong = Long.parseLong(req.queryParams("galaxy"));

                for (SolarSystem solarSystem : solarSystems) {
                    if (solarSystem.getId() == galaxyIdLong) {
                        currentSolarSystem = solarSystem;
                    }
                }
                Planet currentPlanet = new Planet(name, description, weather, currentSolarSystem);
                currentPlanet.setPlanetPicture(planetPictureDefault);
                queryHandler.persistData(planetPictureDefault);
                queryHandler.persistData(currentPlanet);
            }
        }

        Map params = new HashMap<>();

        params.put("loggedIn", userId != null);
        params.put("solarsystems", solarSystems);

        return params;
    }

}
