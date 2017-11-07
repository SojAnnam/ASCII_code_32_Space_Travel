package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
    @Id @GeneratedValue
    private long id;
    @ManyToOne
    private Accomodation accomodation;
    private double price;
    @ManyToOne
    private RoomType roomType;

    public Room() {
    }

    public Room(Accomodation accomodation, double price, RoomType roomType) {
        this.accomodation = accomodation;
        this.price = price;
        this.roomType = roomType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }
}
