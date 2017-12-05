package com.codecool.spacetravel.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROOMTYPE")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int bednumber;

    @OneToMany(mappedBy = "roomType")
    private List<Room> rooms =new ArrayList<>();

    public RoomType() {
    }

    public RoomType(String name, int bednumber) {
        this.name = name;
        this.bednumber = bednumber;
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

    public int getBednumber() {
        return bednumber;
    }

    public void setBednumber(int bednumber) {
        this.bednumber = bednumber;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}


