package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Accomodation;
import com.codecool.spacetravel.Model.Planet;
import com.codecool.spacetravel.Model.Room;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomController {

    public static ModelAndView renderRooms(Request req, Response res, EntityManager em){
        long acommodationId = Long.parseLong(req.params(":id"));
        List<Room> roomList = QueryController.getRoomsByAcommodationId(acommodationId, em);

        List<Accomodation> accList = QueryController.getAccomodationById(acommodationId, em);
        Accomodation selectedAccomodation = accList.get(0);

        Map params = new HashMap<>();
        params.put("roomlist", roomList);
        params.put("accomodation", selectedAccomodation);
        return new ModelAndView(params, "roomreservation");
    }
}
