package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class RoomReservation {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private User user;
    private Date date;


}
