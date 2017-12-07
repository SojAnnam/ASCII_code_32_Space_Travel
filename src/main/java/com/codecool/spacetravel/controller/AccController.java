package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.controller.collectdata.AccDataHandler;
import com.codecool.spacetravel.controller.collectdata.CustomerDataHandler;
import com.codecool.spacetravel.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccController {

    @Autowired
    private AccDataHandler accDataHandler;
    @Autowired
    private QueryHandler queryHandler;
    @Autowired
    private CustomerDataHandler customerDataHandler;

    @RequestMapping(value = "/{planetId}/accomodation", method = RequestMethod.GET)
    public String renderAcc(Model model,
                            @PathVariable("planetId") long planetId,
                            HttpServletRequest httpServletRequest) {
        accDataHandler.collectAccData(model, planetId, httpServletRequest);
        return "accomodation";
    }

    @RequestMapping(value = "/registration-accommodation", method = RequestMethod.GET)
    public String registerAcc(Model model, HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        if( customerId== null || !customerDataHandler.checkUserLegitimacy(customerId)){
            return "redirect:/";
        }

        List<Planet> allPlanet = queryHandler.getAllPlanet();
        List<AmenityType> amenityTypes = queryHandler.getAllAmenity();

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("planets", allPlanet);
        model.addAttribute("amenityTypes", amenityTypes);
        model.addAttribute("accomodation", new Accomodation());
        model.addAttribute("errors", new ArrayList<>());
        return "registration_accommodation";
    }

    @RequestMapping(value = "/registration-accommodation", method = RequestMethod.POST)
    public String saveAcc(Model model, Accomodation accomodation, HttpServletRequest httpServletRequest) {

        if (!accomodation.getName().equals("") && !accomodation.getDescription().equals("")
                && !accomodation.getAmenityTypes().isEmpty() && accomodation.getPlanet() != null) {
            AccomodationPicture accomodationPicture = new AccomodationPicture("default-accommodation.jpg", "def-acc", "def-acc");
            accomodationPicture.setAccomodation(accomodation);
            queryHandler.saveAccommodation(accomodation);
            queryHandler.saveAccommodationPicture(accomodationPicture);
            return "redirect:/" + accomodation.getPlanet().getId() + "/accomodation";
        } else {
            Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
            String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");
            ArrayList<String> errors = new ArrayList<>();
            errors.add("The inputs are not valid");
            List<Planet> allPlanet = queryHandler.getAllPlanet();
            List<AmenityType> amenityTypes = queryHandler.getAllAmenity();
            model.addAttribute("loggedIn", customerId != null);
            model.addAttribute("customername", customerName);
            model.addAttribute("errors", errors);
            model.addAttribute("accomodation", accomodation);
            model.addAttribute("planets", allPlanet);
            model.addAttribute("amenityTypes", amenityTypes);
        }

        return "registration_accommodation";
    }


}
