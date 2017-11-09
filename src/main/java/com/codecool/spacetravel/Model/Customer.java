package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.List;
import java.util.ResourceBundle;

@NamedQueries({
        @NamedQuery(
                name = "Customer.getAllCustomers",
                query = "SELECT c FROM Customer c"
        )
})
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String address, email, password;

    @OneToMany(mappedBy = "customer")
    private List<RoomReservation> roomReservation;

    public Customer() {
    }

    public Customer(String name, String address, String email, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.password = password;
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

    public List<RoomReservation> getRoomReservation() {
        return roomReservation;
    }

    public void setRoomReservation(List<RoomReservation> roomReservation) {
        this.roomReservation = roomReservation;
    }
}

