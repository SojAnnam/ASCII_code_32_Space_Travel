package com.codecool.spacetravel.Model;

import javax.persistence.*;


@Entity
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private String weather;
    @ManyToOne
    private SolarSystem solarSystem;
    @OneToOne
    private Picture picture;
    @OneToMany(mappedBy = "planet")
    private Accomodation accomodation;

}

