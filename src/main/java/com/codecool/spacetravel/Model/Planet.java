package com.codecool.spacetravel.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String weather;
    @ManyToOne
    private SolarSystem solarsystem;
    @OneToOne
    private Picture picture;

    @OneToMany(mappedBy = "planet")
    private List<Accomodation> accomodation;




    public Planet(String name, String description, String weather, SolarSystem solarSystem) {
        this.name = name;
        this.description = description;
        this.weather = weather;
        this.solarsystem = solarSystem;
    }

    public Planet() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public SolarSystem getSolarSystem() {
        return solarsystem;
    }

    public void setSolarSystem(SolarSystem solarSystem) {
        this.solarsystem = solarSystem;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Collection<Accomodation> getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(List<Accomodation> accomodation) {
        this.accomodation = accomodation;
    }
}

