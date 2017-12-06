package com.codecool.spacetravel.model;


import javax.persistence.*;

@Entity
@Table(name = "AMENITYTYPE")
public class AmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, faId;

    public AmenityType() {
    }

    public AmenityType(String name, String faId) {
        this.name = name;
        this.faId = faId;
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

    public String getFaId() {
        return faId;
    }

    public void setFaId(String faId) {
        this.faId = faId;
    }
}
