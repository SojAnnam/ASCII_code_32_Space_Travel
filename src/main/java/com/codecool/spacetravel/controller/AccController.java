package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.AccDataHandler;
import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.datahandler.QueryHandler;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Planet;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccController {

    private  AccDataHandler accDataHandler;



    public AccController(AccDataHandler accDataHandler) {
        this.accDataHandler = accDataHandler;
    }

    public ModelAndView renderAcc(Request req, Response res, long planetId) {

        Map params = accDataHandler.renderAccHandler(req,planetId);

        return new ModelAndView(params, "accomodation");
    }
}
