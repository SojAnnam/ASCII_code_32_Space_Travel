package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.RoomDataHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class RoomController {

    private RoomDataHandler roomDataHandler;

    public RoomController(RoomDataHandler roomDataHandler) {
        this.roomDataHandler = roomDataHandler;
    }

    @RequestMapping(value = "/reservation/{accomodationid}", method = RequestMethod.GET)
    public String renderRooms(@RequestParam Map<String,String> allRequestParams,
                              Model model,
                              @PathVariable("accomodationid") String id,
                              HttpServletRequest httpServletRequest){
        allRequestParams.put("accomodationIdFromURL", id);
        roomDataHandler.collectRoomsData(allRequestParams, model, httpServletRequest);

        return "roomreservation";
    }

    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    public String renderRooms(@RequestParam Map<String,String> allRequestParams,
                              Model model,
                              HttpServletRequest httpServletRequest){
        roomDataHandler.collectRoomsData(allRequestParams, model, httpServletRequest);

        return "roomreservation";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String renderRoomReservationSaving(@RequestParam Map<String,String> allRequestParams,
                                              Model model,
                                              HttpServletRequest httpServletRequest) {

        roomDataHandler.collectRoomReservationSavingData(allRequestParams, model, httpServletRequest);

        return "reservationsaving";
    }

}
