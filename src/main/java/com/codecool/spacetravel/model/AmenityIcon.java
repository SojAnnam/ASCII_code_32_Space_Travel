package com.codecool.spacetravel.model;

import javax.persistence.*;

@Entity
public class AmenityIcon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fileName;

    @OneToOne(mappedBy = "amenityIcon")
    private AmenityType amenityType;

    public AmenityIcon(String fileName) {
        this.fileName = fileName;
    }

    public AmenityIcon() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
