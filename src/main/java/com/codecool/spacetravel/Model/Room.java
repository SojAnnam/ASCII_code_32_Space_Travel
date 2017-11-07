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
}
