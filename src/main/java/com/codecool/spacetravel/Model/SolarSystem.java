package com.codecool.spacetravel.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "SolarSystem.getAllSolarSystem",
                query = "SELECT s FROM SolarSystem s"
        )
})
@Entity
@Table(name = "SolarSystem")
public class SolarSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "solarsystem")
    private List<Planet> planets;

    public static List<SolarSystem> solarSystemList = new ArrayList<>();

    public SolarSystem() {
    }

    public SolarSystem(String name) {
        this.name = name;
        solarSystemList.add(this);
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

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
