package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.PlanetPicture;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.SolarSystem;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class PlanetDataHandler{


    QueryHandler queryHandler;

    public PlanetDataHandler(QueryHandler queryHandler) {

        this.queryHandler = queryHandler;
    }

    public Model collectPlanetData(@RequestParam Map<String,String> allRequestParams,
                                 Model model,
                                 HttpServletRequest httpServletRequest,
                                 boolean newCustomerSaved){
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        long solarSystemId = 1;

        if (allRequestParams.get("solarSystemId") != null){
            solarSystemId = Integer.parseInt(allRequestParams.get("solarSystemId"));
        }

        List<SolarSystem> solarSystemsList = queryHandler.getAllSolarSystem();
        List<Planet> planetListBySolarSystem = queryHandler.getPlanetsBySolarSystemId(solarSystemId);
        List<Planet> allPlanet = queryHandler.getAllPlanet();

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("solarsystems",solarSystemsList);
        model.addAttribute("planets", planetListBySolarSystem);
        model.addAttribute("allplanet",allPlanet);
        model.addAttribute("newcustomersaved", newCustomerSaved);

        return model;
    }

    public Model collectPlanetRegistrationData(@RequestParam Map<String,String> allRequestParams,
                                             Model model,
                                             HttpServletRequest httpServletRequest) {
        Integer userId = (Integer) httpServletRequest.getSession().getAttribute("user_id");

        List<SolarSystem> solarSystems = queryHandler.getAllSolarSystem();

        String name = allRequestParams.get("name");
        String description = allRequestParams.get("desc");
        String weather = allRequestParams.get("weather");

        if (name != null && description != null  && weather != null) {
            if (!name.equals("") && !description.equals("")  && !weather.equals("")) {
                PlanetPicture planetPictureDefault = new PlanetPicture("default-planet.jpg","default-text", "default-title");
                SolarSystem currentSolarSystem = null;
                long galaxyIdLong = Long.parseLong(allRequestParams.get("galaxy"));

                for (SolarSystem solarSystem : solarSystems) {
                    if (solarSystem.getId() == galaxyIdLong) {
                        currentSolarSystem = solarSystem;
                    }
                }
                Planet currentPlanet = new Planet(name, description, weather, currentSolarSystem);
                currentPlanet.setPlanetPicture(planetPictureDefault);
                queryHandler.savePlanetPicture(planetPictureDefault);
                queryHandler.savePlanet(currentPlanet);
            }
        }


        model.addAttribute("loggedIn", userId != null);
        model.addAttribute("solarsystems", solarSystems);

        return model;
    }

}
