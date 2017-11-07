package com.codecool.spacetravel.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AmenityType {
    @Id @GeneratedValue
    private long id;
    private String name;
}
