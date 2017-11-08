package com.codecool.spacetravel.Model;

import javax.persistence.*;

@Entity
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String fileName;

    private String description;

    private String title;

    @OneToOne(mappedBy = "picture")
    private Planet planet;

    @OneToOne(mappedBy = "picture")
    private Accomodation accomodation;

    public Picture() {
    }

    public Picture(String fileName, String description, String title) {

        this.fileName = fileName;
        this.description = description;
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
