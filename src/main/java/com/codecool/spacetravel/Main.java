package com.codecool.spacetravel;

import com.codecool.spacetravel.Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

import com.codecool.spacetravel.Model.*;

import javax.swing.text.PlainDocument;

public class Main {


    public static void populateDb(EntityManager em) {

        Picture picture1 = new Picture("geonosis.jpg","Ugly intersects", "geonosis");
        Picture picture2 = new Picture("jabba_palace.jpg","Jabba and his bounty hunters will be your neighbour", "jabba_palace");
        Picture picture3 = new Picture("mars.jpg","The planet where maybe exists life", "mars");
        Picture picture4 = new Picture("marsbase1.jpg","Hotel with silo", "marsbase1");
        Picture picture5 = new Picture("marsbase2.jpg","ESA Hotel", "marsbase2");
        Picture picture6 = new Picture("moon.jpg","The place of waving flag", "moon");
        Picture picture7 = new Picture("mos_esley.jpg","Han Solo and Luke: The beginning of a beautiful friendship", "mos_esley");
        Picture picture8 = new Picture("saturn.jpg","Giant Planet with giant ring", "saturn");
        Picture picture9 = new Picture("tatooine.jpg","Desert Planet", "tatooine");
        Picture picture10 = new Picture("venusville.jpg","Total Recall", "venusville");



        SolarSystem solarSystem1 = new SolarSystem("Milky Way");
        SolarSystem solarSystem2 = new SolarSystem("Star Wars");
        String description = "the place where we live";
        String weather = "The winter is coming";
        Planet planet1 = new Planet("Mars",description,weather,solarSystem1);
        planet1.setPicture(picture3);

        String discription2 = "Far far away from home";
        String weather2 = "Sun is shining";
        Planet planet2 = new Planet("Moon",discription2,weather2,solarSystem1);
        planet2.setPicture(picture6);

        Accomodation accomodation1 = new Accomodation("Mars base 1",planet1,"Hotel with green plants",picture4);
        Accomodation accomodation2 = new Accomodation("Welcome Hotel",planet1,"ESA Hotel for backpackers", picture5);
        Accomodation accomodation3 = new Accomodation("Come and Maybe go Apartman",planet1,"Venus Ville",picture10);



        RoomType roomType = new RoomType("Single Room",1);
        Room room = new Room(accomodation1,300,roomType);
        Room room2 = new Room(accomodation1,400,roomType);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room2);
        roomType.setRooms(rooms);
        accomodation1.setRooms(rooms);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(picture3);
        em.persist(picture4);
        em.persist(picture5);
        em.persist(picture6);
        em.persist(picture7);
        em.persist(picture10);
        em.persist(solarSystem1);
        em.persist(solarSystem1);
        em.persist(solarSystem1);
        em.persist(solarSystem2);
        em.persist(planet1);
        em.persist(planet2);
        em.persist(accomodation1);
        em.persist(accomodation2);
        em.persist(accomodation3);
        em.persist(roomType);
        em.persist(room);
        em.persist(room2);
        transaction.commit();
        System.out.println("Room saved.");








    }
    public static void main(String[] args) {

        System.out.println("HI");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        populateDb(em);

        em.close();
        emf.close();
    }
}
