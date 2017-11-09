package com.codecool.spacetravel.Model;


import javax.persistence.*;

@Entity
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    private String startDate;

    private String endDate;

    @ManyToOne
    private Room room;

    public RoomReservation(){}

    public RoomReservation(Customer customer, String startDate, String endDate, Room room) {
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDateInStringFormat) {
        this.startDate = startDateInStringFormat;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDateInStringFormat) {
        this.endDate = endDateInStringFormat;
    }
}
