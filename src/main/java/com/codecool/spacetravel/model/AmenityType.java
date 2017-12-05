package com.codecool.spacetravel.model;


import javax.persistence.*;

@Entity
@Table(name = "AMENITYTYPE")
public class AmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public AmenityType() {
    }

    public AmenityType(String name) {
        this.name = name;
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
}
