package com.codecool.spacetravel.Model;

import javax.persistence.*;
import java.util.Collection;


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
    private Collection<Accomodation> accomodation;




}

