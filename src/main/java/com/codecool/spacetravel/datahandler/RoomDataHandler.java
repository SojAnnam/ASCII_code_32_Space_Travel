package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Accomodation;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.Room;
import com.codecool.spacetravel.model.RoomReservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RoomDataHandler {

    private EntityManager em;

    public RoomDataHandler(EntityManager em) {
        this.em = em;
    }

    public List<Room> getRoomsByAcommodationId(long acommodationId) {
        List<Room> results = em.createNamedQuery("Room.getRoomsByAcommodationId", Room.class)
                .setParameter("acommodationId", acommodationId).getResultList();
        return results;
    }

    public List<Accomodation> getAccomodationById(long acommodationId) {
        List<Accomodation> results = em.createNamedQuery("Accomodation.getAccomodationById", Accomodation.class)
                .setParameter("accomodationId", acommodationId).getResultList();
        return results;
    }

    public Room getRoomById(long roomId) {
        Room room = null;
        try {
            room = em.createNamedQuery("Room.getRoomById", Room.class)
                    .setParameter("roomId", roomId).getSingleResult();
        } catch (Exception e){
            System.out.println("No room.");
        }
        return room;
    }

    public Customer getCustomerById(Long customerId) {
        Customer customer = null;
        try{
            customer = em.createNamedQuery("Customer.getCustomerById", Customer.class)
                    .setParameter("id", customerId).getSingleResult();
        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

    public void filterOutReservedRooms(String startDateStringFromUser, String endDateStringFromUser, List<Room> roomList) {
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
        long customerId = Long.parseLong(roomReservationDatas.get("customerId"));
        long roomId = Long.parseLong(roomReservationDatas.get("roomId"));

        Room room = getRoomById(roomId);

        if (room != null) {

            Customer customer = getCustomerById(customerId);

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

            try {
                EntityTransaction transaction = em.getTransaction();
                transaction.begin();
                em.persist(roomReservation);
                transaction.commit();
                savingSucceeded = true;
            } catch (Exception e){
                System.out.println("SAVING FAILED: " + e.getMessage());
                errorMessages.add("Database problem. Please, try later.");
            }
        } else {
            errorMessages.add("Room not found in database.");
        }

        return savingSucceeded;
    }

}
