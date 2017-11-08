package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    private Date date;

    @ManyToOne
    private Room room;

    public RoomReservation(){}

    public RoomReservation(Customer customer, Date date, Room room) {
        this.customer = customer;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
