package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Accomodation accomodation;

    private double price;

    @ManyToOne
    private RoomType roomType;

    @OneToMany(mappedBy = "room")
    List<RoomReservation> roomReservations = new ArrayList<>();

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

    public List<RoomReservation> getRoomReservations() {
        return roomReservations;
    }

    public void setRoomReservations(List<RoomReservation> roomReservations) {
        this.roomReservations = roomReservations;
    }
}
