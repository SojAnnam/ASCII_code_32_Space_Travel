package com.codecool.spacetravel.Model;

import javax.persistence.*;

@Entity
public class Accomodation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    private Planet planet;
    @OneToMany(mappedBy = "accomodation")
    private Room room;
    private String description;
    @OneToOne
    private Picture picture;

    public Accomodation(String name, Planet planet, String description, Picture picture) {
        this.name = name;
        this.planet = planet;
        this.description = description;
        this.picture = picture;
    }

    public Accomodation() {
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

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
