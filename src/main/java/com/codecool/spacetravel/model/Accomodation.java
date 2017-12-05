package com.codecool.spacetravel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedQueries(
        {@NamedQuery(name = "getAccByPlanetId",
                query = "SELECT a from Accomodation a where a.planet.id = :planetId"
        ),@NamedQuery(
                name = "Accomodation.getAccomodationById",
                query = "SELECT a FROM Accomodation a WHERE a.id = :accomodationId"
        ),@NamedQuery(
                name = "Accomodation.getAmenitiesById",
                query = "SELECT a FROM Accomodation a WHERE a.id = :accomodationId"
        )
        })
@Entity
public class Accomodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "accomodation")
    private List<AmenityType> amenityType;

    @ManyToOne
    private Planet planet;

    @OneToMany(mappedBy = "accomodation")
    private List<Room> rooms = new ArrayList<>();

    private String description;

    @OneToMany(mappedBy = "accomodation")
    private List<AccomodationPicture> accomodationPictures = new ArrayList<>();

    public Accomodation() {
    }

    public Accomodation(List<AmenityType> amenityType,String name, Planet planet, String description) {
        this.amenityType = amenityType;
        this.name = name;
        this.planet = planet;
        this.description = description;
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

    public List<AccomodationPicture> getAccomodationPictures() {
        return accomodationPictures;
    }

    public void setAccomodationPictures(List<AccomodationPicture> accomodationPictures) {
        this.accomodationPictures = accomodationPictures;
    }

    public List <AmenityType> getAmenityType() {
        return amenityType;
    }

    public void setAmenityType( List<AmenityType> amenityType) {
        this.amenityType = amenityType;
    }

    @Override
    public String toString() {
        return "Accomodation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", planet=" + planet.getName() +
                ", rooms=" + rooms +
                ", description='" + description + '\'' +
                ", planetPicture=" + accomodationPictures +
                '}';
    }
}
