package com.codecool.spacetravel.Model;


import javax.persistence.*;
import java.util.List;
import java.util.ResourceBundle;

@NamedQueries({
        @NamedQuery(
                name = "Customer.getAllCustomers",
                query = "SELECT c FROM Customer c"
        ),
        @NamedQuery(
                name="Customer.getCustomerByEmail",
                query = "SELECT c FROM Customer c WHERE c.email = :email"
        ),
        @NamedQuery(
                name = "Customer.getCustomerById",
                query = "SELECT c FROM Customer c WHERE c.id = :id"
        )
})
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String country;
    private String city;
    private String postalcode;
    private String address;
    private String password;

    @OneToMany(mappedBy = "customer")
    private List<RoomReservation> roomReservation;

    public Customer() {
    }

    public Customer(String name, String email, String country, String city, String postalcode, String address, String password) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.city = city;
        this.postalcode = postalcode;
        this.address = address;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getpostalcode() {
        return postalcode;
    }

    public void setpostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public List<RoomReservation> getRoomReservation() {
        return roomReservation;
    }

    public void setRoomReservation(List<RoomReservation> roomReservation) {
        this.roomReservation = roomReservation;
    }
}

