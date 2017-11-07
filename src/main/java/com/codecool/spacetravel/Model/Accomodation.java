package com.codecool.spacetravel.Model;

import javax.persistence.*;

@Entity
public class Accomodation {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToOne
    private Planet planet;
    @OneToMany(mappedBy = "accomodation")
    private Room room;
    private String description;
    @OneToOne
    private Picture picture;

}
