package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.model.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomController {

    public static ModelAndView renderRooms(Request req, Response res, EntityManager em){

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        List<String> errorMessages = new ArrayList();

        long accommodationId;
        if (req.queryParams().size() > 1){
            accommodationId = Long.parseLong(req.queryParams("selected-accomodation-id"));
        } else {
            accommodationId = Long.parseLong(req.params(":id"));
        }

        List<Room> roomList = QueryController.getRoomsByAcommodationId(accommodationId, em);
        List<String> dateElements = new ArrayList<>();

        if (req.queryParams().size() > 1){
            String startDateStringFromUser = req.queryParams("start-date");
            String endDateStringFromUser = req.queryParams("end-date");
            System.out.println(startDateStringFromUser);
            System.out.println(endDateStringFromUser);
            errorMessages = validateDates(startDateStringFromUser, endDateStringFromUser, roomList, em);
            dateElements.add(startDateStringFromUser);
            dateElements.add(endDateStringFromUser);
        } else {
            dateElements.add("");
            dateElements.add("");
        }

        List<Accomodation> accomodationList = QueryController.getAccomodationById(accommodationId, em);
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
    
    private static List<String> validateDates(String startDateStringFromUser,
                                              String endDateStringFromUser,
                                              List<Room> roomList,
                                              EntityManager em) {

        List<String> errorMessages = new ArrayList<>();
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date startDateFromUser = dateformat.parse(startDateStringFromUser);
            Date endDateFromUser = dateformat.parse(endDateStringFromUser);

            String[] startDateElements = startDateStringFromUser.split("/");
            String startDateYear = startDateElements[0];
            String startDateMonth = startDateElements[1];
            String startDateDay = startDateElements[2];

            String[] endDateElements = endDateStringFromUser.split("/");
            String endDateYear = endDateElements[0];
            String endDateMonth = endDateElements[1];
            String endDateDay = endDateElements[2];

            boolean datesAreValid = true;

            if (startDateFromUser.after(endDateFromUser) || startDateFromUser.equals(endDateFromUser)){
                errorMessages.add("Start date must be earlier than end date.");
                datesAreValid = false;
            }
            if (startDateFromUser.before(new Date())) {
                errorMessages.add("Start date must be later than current date.");
                datesAreValid = false;
            }
            if (Integer.parseInt(startDateMonth) < 1 || Integer.parseInt(startDateMonth) > 12 ||
                    Integer.parseInt(endDateMonth) < 1 || Integer.parseInt(endDateMonth) > 12){
                errorMessages.add("Month must be greater than 0 and lesser than 13.");
                datesAreValid = false;
            }

            int maxDay = 0;
            String[] longMonths = {"01", "03", "05", "07", "08", "10", "12"};
            if (Arrays.asList(longMonths).contains(startDateDay)) {
                maxDay = 31;
            } else if (startDateDay.equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(startDateDay) < 1 ||
                    Integer.parseInt(startDateDay) > maxDay){
                errorMessages.add("Day in start date should be between 1 and " + maxDay + ".");
                datesAreValid = false;
            }

            if (Arrays.asList(longMonths).contains(endDateDay)) {
                maxDay = 31;
            } else if (endDateDay.equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(endDateDay) < 1 ||
                    Integer.parseInt(endDateDay) > maxDay){
                errorMessages.add("Day in end date should be between 1 and " + maxDay + ".");
                datesAreValid = false;
            }

            if (datesAreValid){
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
        } catch (Exception e){
            errorMessages.add("Invalid date format.");
        }

        return errorMessages;
    }

    public static ModelAndView renderSaving(Request req, Response res, EntityManager em) {

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        long roomId = Long.parseLong(req.queryParams("selected-room-id"));
        List<Room> rooms = QueryController.getRoomById(roomId, em);
        Room room = rooms.get(0);

        String startDateStringFromUser = req.queryParams("start-date");
        String endDateStringFromUser = req.queryParams("end-date");

        Customer customer = QueryController.getCustomerById(customerId, em);


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(startDateStringFromUser);
            endDate = dateFormat.parse(endDateStringFromUser);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RoomReservation roomReservation = new RoomReservation(customer, startDate, endDate, room);

        List<RoomReservation> reservationsOfCustomer = customer.getRoomReservation();
        reservationsOfCustomer.add(roomReservation);
        customer.setRoomReservation(reservationsOfCustomer);

        List<RoomReservation> reservationsInRoom = room.getRoomReservations();
        reservationsInRoom.add(roomReservation);
        room.setRoomReservations(reservationsInRoom);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(roomReservation);
        transaction.commit();

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        return new ModelAndView(params, "reservationsaved");
    }
}
