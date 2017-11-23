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

    public Accomodation getAccomodationById(long acommodationId) {
        Accomodation accomodation = null;
        try {
            accomodation = em.createNamedQuery("Accomodation.getAccomodationById", Accomodation.class)
                    .setParameter("accomodationId", acommodationId).getSingleResult();

        } catch (Exception e){
            System.out.println("No accomodation.");
        }
        return accomodation;
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

        Room room = getRoomById(roomId);

        if (room != null) {

            Customer customer = getCustomerById(customerId);

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
