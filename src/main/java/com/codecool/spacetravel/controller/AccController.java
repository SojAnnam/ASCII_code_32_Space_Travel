package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.controller.collectdata.AccDataHandler;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.AccomodationPicture;
import com.codecool.spacetravel.model.AmenityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class AccController {

    @Autowired
    private AccDataHandler accDataHandler;
    @Autowired
    private QueryHandler queryHandler;

    @RequestMapping(value = "/{planetId}/accomodation", method = RequestMethod.GET)
    public String renderAcc(Model model,
                            @PathVariable("planetId") long planetId,
                            HttpServletRequest httpServletRequest) {
        accDataHandler.collectAccData(model, planetId, httpServletRequest);
        return "accomodation";
    }

    @RequestMapping(value = "/registration-accommodation", method = RequestMethod.GET)
    public String renderAcc(Model model, HttpServletRequest httpServletRequest) {
        accDataHandler.collectAccRegistrationData(model, httpServletRequest);
        return "registration_accommodation";
    }

    @RequestMapping(value = "/registration-accommodation", method = RequestMethod.POST)
    public String saveAcc(Accomodation accomodation) {
        AccomodationPicture accomodationPicture = new AccomodationPicture("default-accommodation.jpg", "def-acc", "def-acc");
        accomodationPicture.setAccomodation(accomodation);
        queryHandler.saveAccommodation(accomodation);
        queryHandler.saveAccommodationPicture(accomodationPicture);
        return "redirect:/registration-accommodation";
    }


}
