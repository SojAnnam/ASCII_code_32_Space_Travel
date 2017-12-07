package com.codecool.spacetravel.DAO;

import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.model.RoomReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class RoomDao {

    @Autowired
    private QueryHandler queryHandler;


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

    public boolean saveRoomReservation(Long customerId,
                                       String startDateStringFromUser,
                                       String endDateStringFromUser,
                                       List<Long> roomIds,
                                       List<String> errorMessages){
        boolean savingSucceeded = false;

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

            for (Long roomId : roomIds){

                Room room = queryHandler.getRoomById(roomId);

                if (room != null) {

                        if (roomIsFree(room, startDate, endDate)){
                            RoomReservation roomReservation = new RoomReservation(customer, startDate, endDate, room);

                            List<RoomReservation> reservationsOfCustomer = customer.getRoomReservation();
                            reservationsOfCustomer.add(roomReservation);
                            customer.setRoomReservation(reservationsOfCustomer);

                            List<RoomReservation> reservationsInRoom = room.getRoomReservations();
                            reservationsInRoom.add(roomReservation);
                            room.setRoomReservations(reservationsInRoom);

                            try {
                                queryHandler.saveRoomReservation(roomReservation);
                                savingSucceeded = true;
                            } catch (Exception e){
                                System.out.println("SAVING FAILED: " + e.getMessage());
                                errorMessages.add("Database problem. Please, try later.");
                            }

                        } else {
                            errorMessages.add(room.getRoomType().getName() + " (beds: " + room.getRoomType().getBednumber() + ") is already reserved in the choosed time interval.");
                        }


                } else {
                    errorMessages.add("Room not found in database.");
                }
            }

        } else {
            errorMessages.add("Database problem. Please, try it later.");
            System.out.println("Customer not found in database.");
        }

        return savingSucceeded;
    }

    private boolean roomIsFree(Room room, Date startDate, Date endDate) {
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

}