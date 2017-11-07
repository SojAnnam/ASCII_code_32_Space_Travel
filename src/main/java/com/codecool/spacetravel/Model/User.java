package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.List;
import java.util.ResourceBundle;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String address, email, password;
    @OneToMany(mappedBy = "user")
    private List<RoomReservation> roomReservation;

}

