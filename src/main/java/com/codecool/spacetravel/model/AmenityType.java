package com.codecool.spacetravel.model;


import org.hibernate.sql.Select;

import javax.persistence.*;
import java.util.List;


@NamedQueries(
        @NamedQuery(name = "AmenityType.getAmenitiesByAccomodationId",
                query = "SELECT a FROM AmenityType a where a.id = :id"))
@Entity
@Table(name = "AMENITYTYPE")
public class AmenityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, faId;

    @ManyToMany(mappedBy = "amenityTypes")
    private List<Accomodation> accomodations;

//    @OneToOne
//    private AmenityIcon amenityIcon;

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
    public void setAccomodations(List<Accomodation> accomodations) {
        this.accomodations = accomodations;
    }

    public List<Accomodation> getAccomodations() {
        return accomodations;
    }

    public String getFaId() {
        return faId;
    }

    public void setFaId(String faId) {
        this.faId = faId;
    }
}
