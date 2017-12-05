package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.PlanetDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Scope("session")
public class PlanetRegistrationController {

    @Autowired
    PlanetDataHandler planetDataHandler;

    @RequestMapping(value = "registration-planet", method = {RequestMethod.GET, RequestMethod.POST})
    public String renderPlanetRegistration(@RequestParam Map<String,String> allRequestParams,
                                           Model model,
                                           HttpServletRequest httpServletRequest) {
        model = planetDataHandler.collectPlanetRegistrationData(allRequestParams, model, httpServletRequest);
        return "registration_planet";
    }

}
