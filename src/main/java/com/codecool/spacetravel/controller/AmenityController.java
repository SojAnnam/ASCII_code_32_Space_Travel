package com.codecool.spacetravel.controller;


import com.codecool.spacetravel.controller.collectdata.AmenityDataHandler;
import com.codecool.spacetravel.controller.collectdata.CustomerDataHandler;
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

    @Autowired
    private CustomerDataHandler customerDataHandler;

    @RequestMapping(value = "/addamenity", method = {RequestMethod.GET, RequestMethod.POST})
    public String renderAcc(@RequestParam Map<String, String> allRequestParams,
                            Model model,
                            HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        
        if (customerId == null || !customerDataHandler.checkUserLegitimacy(customerId)) {
            return "redirect:/";
        }

        amenityDataHandler.collectAmenityData(allRequestParams, model, httpServletRequest);
        return "add_amenity";
    }
}


