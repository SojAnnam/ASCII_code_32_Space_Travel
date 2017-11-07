package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ResourceBundle;

@Entity
public class User {
    private long id;
    private String name;
    private String address, email, password;
    @OneToMany(mappedBy = "roomreservation")
    private RoomReservation roomReservation;

}

