package com.codecool.spacetravel.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Picture {
    @Id @GeneratedValue
    private long id;
    private String path;
    private String discription;
    private String title;
}
