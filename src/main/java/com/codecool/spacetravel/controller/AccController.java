package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.AccDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AccController {

    @Autowired
    private AccDataHandler accDataHandler;

    @RequestMapping(value = "/{planetId}/accomodation", method = RequestMethod.GET)
    public String renderAcc(Model model,
                            @PathVariable("planetId") long planetId,
                            HttpServletRequest httpServletRequest) {
        accDataHandler.collectAccData(model, planetId, httpServletRequest);
        return "accomodation";
    }

}
