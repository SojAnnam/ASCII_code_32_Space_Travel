package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.Date;

@Entity
public class RoomReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User user;
    private Date date;


}
