package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.model.RoomReservation;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.Request;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomDataHandler {

    private QueryHandler queryHandler;
    private RoomReservationDataValidator roomReservationDataValidator;

    public RoomDataHandler(QueryHandler queryHandler,
                           RoomReservationDataValidator roomReservationDataValidator) {
        this.queryHandler = queryHandler;
        this.roomReservationDataValidator = roomReservationDataValidator;
    }

    public void filterReservedRooms(String startDateStringFromUser, String endDateStringFromUser, List<Room> roomList) {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        Date startDateFromUser = null;
        Date endDateFromUser = null;

        try {
            startDateFromUser = dateformat.parse(startDateStringFromUser);
            endDateFromUser = dateformat.parse(endDateStringFromUser);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Room> temp = new ArrayList<>();
        for (Room room : roomList){
            temp.add(room);
        }

        for (Room room : temp){
            List<RoomReservation> reservations = room.getRoomReservations();
            for (RoomReservation reservation : reservations){
                try{
                    Date startDateOfRes = reservation.getStartDate();
                    Date endDateOfRes = reservation.getEndDate();

                    if ((startDateFromUser.before(endDateOfRes) && startDateFromUser.after(startDateOfRes)) ||
                            (endDateFromUser.before(endDateOfRes) && endDateFromUser.after(startDateOfRes)) ||
                            (startDateFromUser.before(startDateOfRes) && endDateFromUser.after(endDateOfRes)) ||
                            startDateFromUser.equals(startDateOfRes) ||
                            startDateFromUser.equals(endDateOfRes) ||
                            endDateFromUser.equals(startDateOfRes) ||
                            endDateFromUser.equals(endDateOfRes)){
                        if(roomList.contains(room)){
                            roomList.remove(room);
                        }
                    }

                } catch (Exception e){
                    System.out.println("INVALID DATE STRING IN ROOMRESERVATION TABLE");
                }
            }
        }
    }

    public boolean saveRoomReservation(Map<String, String> roomReservationDatas, List<String> errorMessages){
        boolean savingSucceeded = false;
        String startDateStringFromUser = roomReservationDatas.get("startDateStringFromUser");
        String endDateStringFromUser = roomReservationDatas.get("endDateStringFromUser");
        long roomId = Long.parseLong(roomReservationDatas.get("roomId"));
        long customerId = Long.parseLong(roomReservationDatas.get("customerId"));

        Room room = queryHandler.getRoomById(roomId);

        if (room != null) {

            Customer customer = queryHandler.getCustomerById(customerId);

            if (customer != null){
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                Date startDate = null;
                Date endDate = null;

                try {
                    startDate = dateFormat.parse(startDateStringFromUser);
                    endDate = dateFormat.parse(endDateStringFromUser);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                if (roomIsFree(room, startDate, endDate)){
                    RoomReservation roomReservation = new RoomReservation(customer, startDate, endDate, room);

                    List<RoomReservation> reservationsOfCustomer = customer.getRoomReservation();
                    reservationsOfCustomer.add(roomReservation);
                    customer.setRoomReservation(reservationsOfCustomer);

                    List<RoomReservation> reservationsInRoom = room.getRoomReservations();
                    reservationsInRoom.add(roomReservation);
                    room.setRoomReservations(reservationsInRoom);

                    try {
                        queryHandler.persistData(roomReservation);
                        savingSucceeded = true;
                    } catch (Exception e){
                        System.out.println("SAVING FAILED: " + e.getMessage());
                        errorMessages.add("Database problem. Please, try later.");
                    }

                } else {
                    errorMessages.add("Room is already reserved in the choosed time interval.");
                }
            } else {
                errorMessages.add("Database problem. Please, try it later.");
                System.out.println("Customer not found in database.");
            }


        } else {
            errorMessages.add("Room not found in database.");
        }

        return savingSucceeded;
    }

    public boolean roomIsFree(Room room, Date startDate, Date endDate) {
        boolean roomIsFree = true;

        List<RoomReservation> reservationsInThisRoom = room.getRoomReservations();
        for (RoomReservation roomReservation : reservationsInThisRoom){
            Date startDateOfReservation = roomReservation.getStartDate();
            Date endDateOfReservation = roomReservation.getEndDate();

            if ((startDate.before(endDateOfReservation) && startDate.after(startDateOfReservation)) ||
                    (endDate.before(endDateOfReservation) && endDate.after(startDateOfReservation)) ||
                    (startDate.before(startDateOfReservation) && endDate.after(endDateOfReservation)) ||
                    startDate.equals(startDateOfReservation) ||
                    startDate.equals(endDateOfReservation) ||
                    endDate.equals(startDateOfReservation) ||
                    endDate.equals(endDateOfReservation)){
                roomIsFree = false;
            }
        }

        return roomIsFree;

    }

    public Map renderRoomsHandler(Request req){
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
                filterReservedRooms(startDateStringFromUser, endDateStringFromUser, roomList);
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

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("roomlist", roomList);
        params.put("accomodation", selectedAccomodation);
        params.put("errors", errorMessages);
        params.put("dateelements", dateElements);
        params.put("reservable", reservable);

        return params;

    }


    public Map renderRoomReservationSavingHandler(Request req) {
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
            savingSucceeded = saveRoomReservation(roomReservationDatas, errorMessages);
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
