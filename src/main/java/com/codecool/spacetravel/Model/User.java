package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ResourceBundle;

@Entity
public class User {
    @Id @GeneratedValue
    private long id;
    private String name;
    private String address, email, password;
    @OneToMany(mappedBy = "roomreservation")
    private RoomReservation roomReservation;

    public User(String name, String address, String email, String password, RoomReservation roomReservation) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
        this.roomReservation = roomReservation;
    }

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoomReservation getRoomReservation() {
        return roomReservation;
    }

    public void setRoomReservation(RoomReservation roomReservation) {
        this.roomReservation = roomReservation;
    }
}

