package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.AccDataHandler;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.Map;

public class AccController {

    private  AccDataHandler accDataHandler;

    public AccController(AccDataHandler accDataHandler) {
        this.accDataHandler = accDataHandler;
    }

    public ModelAndView renderAcc(Request req, Response res, long planetId) {

        Map params = accDataHandler.collectAccData(req,planetId);

        return new ModelAndView(params, "accomodation");
    }
}
