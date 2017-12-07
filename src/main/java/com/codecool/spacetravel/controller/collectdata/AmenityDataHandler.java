package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.AmenityType;
import com.codecool.spacetravel.model.Planet;
import com.codecool.spacetravel.model.PlanetPicture;
import com.codecool.spacetravel.model.SolarSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class AmenityDataHandler {

    @Autowired
    QueryHandler queryHandler;

    public void collectAmenityData(Map<String, String> allRequestParams, Model model,
                                   HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");
        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);

        String name = allRequestParams.get("name");
        String faId = allRequestParams.get("faId");

        if (name != null && faId != null ) {
            if (!name.equals("") && !faId.equals("") ) {
                AmenityType amenity = new AmenityType(name,faId);
                queryHandler.saveAmenity(amenity);
            }
        }

    }
}
