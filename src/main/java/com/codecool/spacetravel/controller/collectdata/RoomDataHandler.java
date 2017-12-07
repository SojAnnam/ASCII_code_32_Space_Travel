package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.DAO.RoomDao;
import com.codecool.spacetravel.model.*;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.model.RoomReservation;
import com.codecool.spacetravel.service.RoomReservationDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoomDataHandler {

    @Autowired
    private QueryHandler queryHandler;

    @Autowired
    private RoomReservationDataValidator roomReservationDataValidator;

    @Autowired
    private RoomDao roomDao;

    public void collectRoomsData(@RequestParam Map<String,String> allRequestParams,
                                Model model,
                                HttpServletRequest httpServletRequest){
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        List<String> errorMessages = new ArrayList();

        long accommodationId = 0;
        if (allRequestParams.size() > 1){
            accommodationId = Long.parseLong(allRequestParams.get("selected-accomodation-id"));
        } else {
            try{
                accommodationId = Long.parseLong(allRequestParams.get("accomodationIdFromURL"));
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

        if (allRequestParams.size() > 1){
            String startDateStringFromUser = allRequestParams.get("start-date");
            String endDateStringFromUser = allRequestParams.get("end-date");
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
        List<AmenityType> faList = queryHandler.getAmenitisByAccomodationId(accommodationId);

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("roomlist", roomList);
        model.addAttribute("accomodation", selectedAccomodation);
        model.addAttribute("errors", errorMessages);
        model.addAttribute("dateelements", dateElements);
        model.addAttribute("reservable", reservable);
        model.addAttribute("faList", faList);

    }


    public void collectRoomReservationSavingData(@RequestParam Map<String,String> allRequestParams,
                                                  Model model,
                                                  HttpServletRequest httpServletRequest) {

        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");
        String startDateStringFromUser = allRequestParams.get("start-date");
        String endDateStringFromUser = allRequestParams.get("end-date");
        Long accomodationId = Long.parseLong(allRequestParams.get("accomodationid"));
        List<Long> roomIds = new ArrayList<>();

        for (String key : allRequestParams.keySet()){
            if (key.startsWith("room-id-")){
                roomIds.add(Long.parseLong(allRequestParams.get(key)));
            }
        }

        List<String> errorMessages = roomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
        boolean savingSucceeded = false;

        if (errorMessages.size() == 0 && roomIds.size() > 0){
            savingSucceeded = roomDao.saveRoomReservation(customerId, startDateStringFromUser, endDateStringFromUser, roomIds, errorMessages);
        } else if (roomIds.size() == 0){
            errorMessages.add("You have not selected room.");
        }

        List<Room> reservedRooms = new ArrayList<>();
        int totalBed = 0;
        double totalPrice = 0;

        if (savingSucceeded){
            for (Long roomId : roomIds){
                Room room = queryHandler.getRoomById(roomId);
                reservedRooms.add(room);
                totalBed += room.getRoomType().getBednumber();
                totalPrice += room.getPrice();
            }
        } else if (!savingSucceeded){
            errorMessages.add("Saving failed.");
        }

        Customer customer = queryHandler.getCustomerById(customerId);

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("customer", customer);
        model.addAttribute("errors", errorMessages);
        model.addAttribute("reservedrooms", reservedRooms);
        model.addAttribute("totalbed", totalBed);
        model.addAttribute("totalprice", totalPrice);
        model.addAttribute("startdate", startDateStringFromUser);
        model.addAttribute("enddate", endDateStringFromUser);
        model.addAttribute("accomodation", queryHandler.getAccomodationById(accomodationId));
    }

    public void collectRoomReservationsByCustomer(Model model, HttpServletRequest httpServletRequest){
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        List<RoomReservation> roomReservations = null;
        Customer customer = null;
        if (customerId != null){
            customer = queryHandler.getCustomerById(customerId);
            roomReservations = queryHandler.getReservationsByCustomerId(customerId);
        }

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("customer", customer);
        model.addAttribute("roomreservations", roomReservations);
    }

    public void addNewRoom(Model model,HttpServletRequest httpServletRequest,String accId){

        long accommodationId = Long.parseLong(accId);
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        Accomodation accomodation = queryHandler.getAccomodationById(accommodationId);
        List<RoomType> roomTypeList =queryHandler.getAllRoomType();


        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("roomTypeList", roomTypeList);
        model.addAttribute("accomodation", accomodation);

    }

    public Model collectNewRoomData(@RequestParam Map<String,String> allRequestParams,String id,
                                              Model model,
                                              HttpServletRequest httpServletRequest) {

        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");
        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);

        String roomTypeIdStr = allRequestParams.get("radio");
        long accId = Long.parseLong(id);
        String priceStr = allRequestParams.get("price");
        String roomNumStr = allRequestParams.get("roomnum");




        if(!priceStr.equals("") && !roomNumStr.equals("") && !roomTypeIdStr.equals("")){
            long roomTypeId = Long.parseLong(allRequestParams.get("radio"));
            double price = Double.parseDouble(allRequestParams.get("price"));
            Integer roomNum = Integer.parseInt(allRequestParams.get("roomnum"));
            RoomType roomType = queryHandler.getRoomTypeById(roomTypeId);
            Accomodation accomodation = queryHandler.getAccomodationById(accId);
            if (price > 0 && roomNum > 0  && roomTypeId != 0) {
                Room room[] = new Room[roomNum];
                for (int i = 0; i <roomNum ; i++) {
                    room[i]= new Room(accomodation,price,roomType);
                    queryHandler.saveNewRoom(room[i]);
                }
            }else{
                String errormessage="Price or Number of Room must be greater than 0";
                model.addAttribute("error",errormessage);

            }

        }else{
            String errormessage="Price, Room number or Roomtype not valid or not selected";
            model.addAttribute("error",errormessage);
        }



    return model;
    }

}
