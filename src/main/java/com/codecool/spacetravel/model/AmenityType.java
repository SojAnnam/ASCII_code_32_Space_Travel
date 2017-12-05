package com.codecool.spacetravel.model;


import javax.persistence.*;

@Entity
public class AmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne
    private Accomodation accomodation;

    @OneToOne
    private AmenityIcon amenityIcon;

    public AmenityType() {
    }


    public AmenityType(Accomodation accomodation,String name) {
        this.accomodation = accomodation;
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

    public Accomodation getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(Accomodation accomodation) {
        this.accomodation = accomodation;
    }
}
