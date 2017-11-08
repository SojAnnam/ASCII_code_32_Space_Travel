package com.codecool.spacetravel.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Accomodation.getAccomodationById",
                query = "SELECT a FROM Accomodation a WHERE a.id = :accomodationId"
        )
})
@Entity
public class Accomodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private Planet planet;

    @OneToMany(mappedBy = "accomodation")
    private List<Room> rooms = new ArrayList<>();

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

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
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

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planet=" + planet.getName() +
                ", rooms=" + rooms +
                ", description='" + description + '\'' +
                ", picture=" + picture.getFileName() +
                '}';
    }
}
