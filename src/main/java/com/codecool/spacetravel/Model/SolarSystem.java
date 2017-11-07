package com.codecool.spacetravel.Model;

import javax.persistence.*;

@Entity
@Table(name = "SolarSystem")
public class SolarSystem {
   @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @OneToMany(mappedBy = "solarsystem")
    private Planet planet;

    public SolarSystem() {
    }
    public SolarSystem(String name) {
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

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}
