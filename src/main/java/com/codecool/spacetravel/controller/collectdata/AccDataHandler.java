package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import spark.Request;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccDataHandler {


    private QueryHandler queryHandler;
    public AccDataHandler(QueryHandler queryHandler) {

        this.queryHandler = queryHandler;
    }

    public Map collectAccData(Request req, long planetId){
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        Planet planet = queryHandler.getPlanet(planetId);

        List<Accomodation> accList = queryHandler.getAccByPlanetId(planetId);

        Map params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("loggedIn", customerId != null);
        params.put("accomodations", accList);
        params.put("planet", planet);

        return params;
    }

}
