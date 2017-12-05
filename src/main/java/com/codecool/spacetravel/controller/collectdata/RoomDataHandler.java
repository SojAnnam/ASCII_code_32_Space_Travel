package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.DAO.RoomDao;
import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.service.RoomReservationDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("roomlist", roomList);
        model.addAttribute("accomodation", selectedAccomodation);
        model.addAttribute("errors", errorMessages);
        model.addAttribute("dateelements", dateElements);
        model.addAttribute("reservable", reservable);

    }


    public void collectRoomReservationSavingData(@RequestParam Map<String,String> allRequestParams,
                                                  Model model,
                                                  HttpServletRequest httpServletRequest) {
        Long customerId = (Long) httpServletRequest.getSession().getAttribute("customer_id");
        String customerName = (String) httpServletRequest.getSession().getAttribute("customer_name");

        String startDateStringFromUser = allRequestParams.get("start-date");
        String endDateStringFromUser = allRequestParams.get("end-date");

        List<String> errorMessages = roomReservationDataValidator.validateDates(startDateStringFromUser, endDateStringFromUser);
        boolean savingSucceeded = false;
        if (errorMessages.size() == 0){
            Map<String, String> roomReservationDatas = new HashMap<>();
            roomReservationDatas.put("customerId", customerId.toString());
            roomReservationDatas.put("roomId", allRequestParams.get("selected-room-id"));
            roomReservationDatas.put("startDateStringFromUser", startDateStringFromUser);
            roomReservationDatas.put("endDateStringFromUser", endDateStringFromUser);
            savingSucceeded = roomDao.saveRoomReservation(roomReservationDatas, errorMessages);
        }

        if (!savingSucceeded){
            errorMessages.add("Saving failed.");
        }

        model.addAttribute("loggedIn", customerId != null);
        model.addAttribute("customername", customerName);
        model.addAttribute("errors", errorMessages);
    }

}
