package com.codecool.spacetravel.model;


import javax.persistence.*;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
                name="RoomReservation.getRoomReservationsByCustomerId",
                query="SELECT rr FROM RoomReservation rr WHERE rr.customer.id = :customerId " +
                        "ORDER BY rr.startDate DESC, " +
                        "rr.endDate DESC, " +
                        "rr.room.accomodation.planet.name ASC, " +
                        "rr.room.accomodation.name ASC, " +
                        "rr.room.roomType.name ASC")
})
@Entity
@Table(name = "ROOMRESERVATION")
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Customer customer;

    @Temporal(TemporalType.DATE)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    private Date endDate;

    @ManyToOne
    private Room room;

    public RoomReservation(){}

    public RoomReservation(Customer customer, Date startDate, Date endDate, Room room) {
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
