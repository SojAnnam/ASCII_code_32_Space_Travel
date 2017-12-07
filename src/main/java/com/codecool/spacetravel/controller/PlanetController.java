package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.CustomerDataHandler;
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

    @Autowired
    CustomerDataHandler customerDataHandler;

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

    @RequestMapping(value = "registration-planet", method = RequestMethod.GET)
    public String renderPlanetRegistration(@RequestParam Map<String,String> allRequestParams,
                                           Model model,
                                           HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        System.out.println(customerId);
        if (customerId == null || !customerDataHandler.checkUserLegitimacy(customerId)) {
            return "redirect:/";

        }
        planetDataHandler.collectPlanetRegistrationData(allRequestParams, model, httpServletRequest);
        return "registration_planet";
    }

    @RequestMapping(value = "registration-planet-form", method = RequestMethod.POST)
    public String collectPlanetRegistrationData(@RequestParam Map<String,String> allRequestParams,
                                           Model model,
                                           HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        if (customerId == null || !customerDataHandler.checkUserLegitimacy(customerId)) {
            return "redirect:/";

        }
        planetDataHandler.collectPlanetRegistrationData(allRequestParams, model, httpServletRequest);
        return "registration_planet";
    }

}
