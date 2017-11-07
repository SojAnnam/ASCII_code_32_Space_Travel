package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RoomType {
    @Id @GeneratedValue
    private long id;
    private String name;
    private int bednumber;
    @OneToMany(mappedBy = "roomtype")
    private Room room;
}
