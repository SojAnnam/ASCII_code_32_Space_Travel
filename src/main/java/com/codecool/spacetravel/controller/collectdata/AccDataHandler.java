package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service
public class AccDataHandler {

    private QueryHandler queryHandler;

    public AccDataHandler(QueryHandler queryHandler) {

        this.queryHandler = queryHandler;
    }

    public Model collectAccData(Map<String,String> allRequestParams,
                                Model model,
                                long planetId,
                                HttpServletRequest httpServletRequest){

        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        Planet planet = queryHandler.getPlanet(planetId);

        List<Accomodation> accList = queryHandler.getAccByPlanetId(planetId);

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("accomodations", accList);
        model.addAttribute("planet", planet);

        return model;
    }

}

