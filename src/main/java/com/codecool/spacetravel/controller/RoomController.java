package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.*;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.SimpleDateFormat;
import java.util.*;

public class RoomController {

    public static ModelAndView renderRooms(Request req, Response res, EntityManager em){

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        long acommodationId = Long.parseLong(req.params(":id"));
        List<Room> roomList = QueryController.getRoomsByAcommodationId(acommodationId, em);

        List<Accomodation> accList = QueryController.getAccomodationById(acommodationId, em);
        Accomodation selectedAccomodation = accList.get(0);

        List<String> errorMessages = new ArrayList();

        List<String> dateElements = new ArrayList<>();
        for (int counter = 0; counter < 6; counter++){
            dateElements.add("");
        }

        Map<String, Object> params = new HashMap<>();
        params.put("loggedIn", customerId != null);
        params.put("customername", customerName);
        params.put("roomlist", roomList);
        params.put("accomodation", selectedAccomodation);
        params.put("errors", errorMessages);
        params.put("dateelements", dateElements);
        params.put("reservable", false);
        return new ModelAndView(params, "roomreservation");
    }

    public static ModelAndView renderRoomsWithDateCheck(Request req, Response res, EntityManager em) {

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        List<String> errorMessages = new ArrayList();
        long acommodationId = Long.parseLong(req.queryParams("selected-accomodation-id"));
        String startDateStringFromUser = req.queryParams("start-date-year") + "/" +
                req.queryParams("start-date-month") + "/" +
                req.queryParams("start-date-day");
        String endDateStringFromUser = req.queryParams("end-date-year") + "/" +
                req.queryParams("end-date-month") + "/" +
                req.queryParams("end-date-day");
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
        List<Room> roomList = QueryController.getRoomsByAcommodationId(acommodationId, em);

        try {
            Date startDateFromUser = dateformat.parse(startDateStringFromUser);
            Date endDateFromUser = dateformat.parse(endDateStringFromUser);

            Date easterEggDate = dateformat.parse("2050/01/01");

            boolean datesAreValid = true;

            if (startDateFromUser.before(easterEggDate)){
                errorMessages.add("Sorry, you can book rooms from 2050/01/01. Space technology is advanced now, but not enough. You will be old and ugly, but it is worth to wait.");
                datesAreValid = false;
            }
            if (startDateFromUser.after(endDateFromUser)){
                errorMessages.add("Start date must be earlier than end date.");
                datesAreValid = false;
            }
            if (startDateFromUser.before(new Date())) {
                errorMessages.add("Start date must be later than current date.");
                datesAreValid = false;
            }
            if (Integer.parseInt(req.queryParams("start-date-month")) < 1 || Integer.parseInt(req.queryParams("start-date-month")) > 12 ||
                    Integer.parseInt(req.queryParams("end-date-month")) < 1 || Integer.parseInt(req.queryParams("end-date-month")) > 12){
                errorMessages.add("Month must be greater than 0 and lesser than 13.");
                datesAreValid = false;
            }

            int maxDay = 0;
            String[] longMonths = {"01", "03", "05", "07", "08", "10", "12"};
            if (Arrays.asList(longMonths).contains(req.queryParams("start-date-day"))) {
                maxDay = 31;
            } else if (req.queryParams("start-date-day").equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(req.queryParams("start-date-day")) < 1 ||
                    Integer.parseInt(req.queryParams("start-date-day")) > maxDay){
                errorMessages.add("Day in start date should be between 1 and " + maxDay + ".");
                datesAreValid = false;
            }

            if (Arrays.asList(longMonths).contains(req.queryParams("end-date-day"))) {
                maxDay = 31;
            } else if (req.queryParams("end-date-day").equals("02")){
                maxDay = 28;
            } else {
                maxDay = 30;
            }

            if (Integer.parseInt(req.queryParams("end-date-day")) < 1 ||
                    Integer.parseInt(req.queryParams("end-date-day")) > maxDay){
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
                            Date startDateOfRes = dateformat.parse(reservation.getStartDate());
                            Date endDateOfRes = dateformat.parse(reservation.getEndDate());

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
            errorMessages.add("Invalid input datas.");
        }

        List<Accomodation> accList = QueryController.getAccomodationById(acommodationId, em);
        Accomodation selectedAccomodation = accList.get(0);

        List<String> dateElements = new ArrayList<>();
        dateElements.add(req.queryParams("start-date-year"));
        dateElements.add(req.queryParams("start-date-month"));
        dateElements.add(req.queryParams("start-date-day"));
        dateElements.add(req.queryParams("end-date-year"));
        dateElements.add(req.queryParams("end-date-month"));
        dateElements.add(req.queryParams("end-date-day"));

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

    public static ModelAndView renderSaving(Request req, Response res, EntityManager em) {

        Long customerId = req.session().attribute("customer_id");
        String customerName = req.session().attribute("customer_name");

        long roomId = Long.parseLong(req.queryParams("selected-room-id"));
        List<Room> rooms = QueryController.getRoomById(roomId, em);
        Room room = rooms.get(0);

        String startDateStringFromUser = req.queryParams("start-date-year") + "/" +
                req.queryParams("start-date-month") + "/" +
                req.queryParams("start-date-day");
        String endDateStringFromUser = req.queryParams("end-date-year") + "/" +
                req.queryParams("end-date-month") + "/" +
                req.queryParams("end-date-day");

        Customer customer = QueryController.getCustomerById(customerId, em);

        RoomReservation roomReservation = new RoomReservation(customer, startDateStringFromUser, endDateStringFromUser, room);

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
