package com.codecool.spacetravel.controller;


import com.codecool.spacetravel.controller.collectdata.AmenityDataHandler;
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
public class AmenityController {


    @Autowired
    private AmenityDataHandler amenityDataHandler;

    @RequestMapping(value = "/addamenity", method = {RequestMethod.GET, RequestMethod.POST})
    public String renderAcc(@RequestParam Map<String,String> allRequestParams,
                            Model model,
//                            @PathVariable("accomodationId") String accomodationId,
                            HttpServletRequest httpServletRequest) {
        amenityDataHandler.collectAmenityData(allRequestParams, model, httpServletRequest);
        return "add_amenity";
    }

}
