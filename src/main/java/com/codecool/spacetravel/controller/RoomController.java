package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.QueryHandler;
import com.codecool.spacetravel.datahandler.RoomDataHandler;
import com.codecool.spacetravel.model.*;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;

public class RoomController {

    private RoomDataHandler roomDataHandler;

    public RoomController(RoomDataHandler roomDataHandler) {
        this.roomDataHandler = roomDataHandler;
    }

    public ModelAndView renderRooms(Request req, Response res){

        Map params = roomDataHandler.renderRoomsHandler(req);

        return new ModelAndView(params, "roomreservation");
    }

    public ModelAndView renderRoomReservationSaving(Request req, Response res) {

        Map params = roomDataHandler.renderRoomReservationSavingHandler(req);

        return new ModelAndView(params, "reservationsaving");
    }

}
