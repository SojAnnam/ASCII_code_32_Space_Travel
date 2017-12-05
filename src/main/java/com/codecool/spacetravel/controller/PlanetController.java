package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.PlanetDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class PlanetController {

    @Autowired
    PlanetDataHandler planetDataHandler;

    @RequestMapping(value = {"/", "/planet"}, method = RequestMethod.GET)
    public String renderPlanets(@RequestParam Map<String,String> allRequestParams,
                                Model model,
                                HttpServletRequest httpServletRequest) {
        planetDataHandler.collectPlanetData(allRequestParams, model, httpServletRequest, false);

        return "index";
    }

    @RequestMapping(value = "/planet/{solarSystemId}", method = RequestMethod.GET)
    public String renderPlanetsBySolarSystem(@RequestParam Map<String,String> allRequestParams,
                                             Model model,
                                             @PathVariable("solarSystemId") String solarSystemId,
                                             HttpServletRequest httpServletRequest) {
        allRequestParams.put("solarSystemId", solarSystemId);
        planetDataHandler.collectPlanetData(allRequestParams, model, httpServletRequest, false);

        return "index";
    }

    @RequestMapping(value = "/customer-registration-succeeded", method = RequestMethod.GET)
    public String renderPlanetsAfterRegistration(@RequestParam Map<String,String> allRequestParams,
                                Model model,
                                HttpServletRequest httpServletRequest) {

        planetDataHandler.collectPlanetData(allRequestParams, model, httpServletRequest, true);

        return "index";
    }

}
