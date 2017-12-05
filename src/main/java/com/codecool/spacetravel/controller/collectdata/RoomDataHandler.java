package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.DAO.RoomDao;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.AmenityType;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomDataHandler {


    private QueryHandler queryHandler;
    private RoomReservationDataValidator roomReservationDataValidator;
    private RoomDao roomDao;

    public RoomDataHandler(QueryHandler queryHandler,
                           RoomReservationDataValidator roomReservationDataValidator,
                           RoomDao roomDao) {
        this.queryHandler = queryHandler;
        this.roomReservationDataValidator = roomReservationDataValidator;
        this.roomDao = roomDao;
    }

    public Map collectRoomsData(Request req){
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        List<String> errorMessages = new ArrayList();

        long accommodationId = 0;
        if (req.queryParams().size() > 1){
            accommodationId = Long.parseLong(req.queryParams("selected-accomodation-id"));
        } else {
            try{
                accommodationId = Long.parseLong(req.params(":id"));
            } catch (Exception e){
                System.out.println("Invalid accommodation id: " + e.getMessage());
            }
        }

        boolean reservable = false;
        List<Room> roomList = new ArrayList<>();
        if (accommodationId != 0){
            roomList = queryHandler.getRoomsByAcommodationId(accommodationId);
        }

        List<String> dateElements = new ArrayList<>();

        if (req.queryParams().size() > 1){
            String startDateStringFromUser = req.queryParams("start-date");
            String endDateStringFromUser = req.queryParams("end-date");
            System.out.println(startDateStringFromUser);
            System.out.println(endDateStringFromUser);
            errorMessages = roomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
            if (errorMessages.size() == 0) {
                roomDao.filterReservedRooms(startDateStringFromUser, endDateStringFromUser, roomList);
                if (customerId != null){
                    reservable = true;
                }
            }
            dateElements.add(startDateStringFromUser);
            dateElements.add(endDateStringFromUser);
        } else {
            dateElements.add("");
            dateElements.add("");
        }

        Accomodation selectedAccomodation = queryHandler.getAccomodationById(accommodationId);
        List<AmenityType> amenityTypes = queryHandler.getAmenitiesByAccomodationId(accommodationId);

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("roomlist", roomList);
        params.put("accomodation", selectedAccomodation);
        params.put("errors", errorMessages);
        params.put("dateelements", dateElements);
        params.put("reservable", reservable);
        params.put("amenityTypes", amenityTypes);

        return params;

    }


    public Map collectRoomReservationSavingData(Request req) {
        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        String startDateStringFromUser = req.queryParams("start-date");
        String endDateStringFromUser = req.queryParams("end-date");

        List<String> errorMessages = roomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
        boolean savingSucceeded = false;
        if (errorMessages.size() == 0){
            Map<String, String> roomReservationDatas = new HashMap<>();
            roomReservationDatas.put("customerId", customerId.toString());
            roomReservationDatas.put("roomId", req.queryParams("selected-room-id"));
            roomReservationDatas.put("startDateStringFromUser", startDateStringFromUser);
            roomReservationDatas.put("endDateStringFromUser", endDateStringFromUser);
            savingSucceeded = roomDao.saveRoomReservation(roomReservationDatas, errorMessages);
        }

        if (!savingSucceeded){
            errorMessages.add("Saving failed.");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("errors", errorMessages);
        return params;
    }

}
