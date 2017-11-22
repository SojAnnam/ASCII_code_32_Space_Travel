package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.RoomDataHandler;
import com.codecool.spacetravel.model.*;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomController {

    private RoomDataHandler roomDataHandler;
    private RoomReservationDataValidator roomReservationDataValidator;

    public RoomController(RoomDataHandler roomDataHandler, RoomReservationDataValidator roomReservationDataValidator) {
        this.roomDataHandler = roomDataHandler;
        this.roomReservationDataValidator = roomReservationDataValidator;
    }

    public ModelAndView renderRooms(Request req, Response res){

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        List<String> errorMessages = new ArrayList();

        long accommodationId;
        if (req.queryParams().size() > 1){
            accommodationId = Long.parseLong(req.queryParams("selected-accomodation-id"));
        } else {
            accommodationId = Long.parseLong(req.params(":id"));
        }

        List<Room> roomList = roomDataHandler.getRoomsByAcommodationId(accommodationId);
        List<String> dateElements = new ArrayList<>();

        if (req.queryParams().size() > 1){
            String startDateStringFromUser = req.queryParams("start-date");
            String endDateStringFromUser = req.queryParams("end-date");
            System.out.println(startDateStringFromUser);
            System.out.println(endDateStringFromUser);
            errorMessages = RoomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
            if (errorMessages.size() == 0) {
                roomDataHandler.filterOutReservedRooms(startDateStringFromUser, endDateStringFromUser, roomList);
            }
            dateElements.add(startDateStringFromUser);
            dateElements.add(endDateStringFromUser);
        } else {
            dateElements.add("");
            dateElements.add("");
        }

        List<Accomodation> accomodationList = roomDataHandler.getAccomodationById(accommodationId);
        Accomodation selectedAccomodation = accomodationList.get(0);

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("roomlist", roomList);
        params.put("accomodation", selectedAccomodation);
        params.put("errors", errorMessages);
        params.put("dateelements", dateElements);
        if (errorMessages.size() == 0 && customerId != null){
            params.put("reservable", true);
        } else {
            params.put("reservable", false);
        }
        return new ModelAndView(params, "roomreservation");
    }

    public ModelAndView renderRoomReservationSaving(Request req, Response res) {

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        String startDateStringFromUser = req.queryParams("start-date");
        String endDateStringFromUser = req.queryParams("end-date");

        List<String> errorMessages = RoomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
        boolean savingSucceeded = false;
        if (errorMessages.size() == 0){
            Map<String, String> roomReservationDatas = new HashMap<>();
            roomReservationDatas.put("customerId", req.session().attribute("customer_id"));
            roomReservationDatas.put("roomId", req.queryParams("selected-room-id"));
            roomReservationDatas.put("startDateStringFromUser", startDateStringFromUser);
            roomReservationDatas.put("endDateStringFromUser", endDateStringFromUser);
            savingSucceeded = roomDataHandler.saveRoomReservation(roomReservationDatas, errorMessages);
        }

        if (!savingSucceeded){
            errorMessages.add("Saving failed.");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("errors", errorMessages);
        return new ModelAndView(params, "reservationsaving");
    }

}
