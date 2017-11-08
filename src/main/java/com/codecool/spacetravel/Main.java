package com.codecool.spacetravel;

import com.codecool.spacetravel.Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void populateDb(EntityManager em) {

        Picture pictureGeonosis = new Picture("geonosis.jpg","Ugly insects", "Geonosis");
        Picture pictureJabbaPalace = new Picture("jabba_palace.jpg","Jabba and his bounty hunters will be your neighbour", "Jabba's palace");
        Picture pictureMars = new Picture("mars.jpg","The planet where maybe exists life", "Mars");
        Picture pictureMarsbase1 = new Picture("marsbase1.jpg","Hotel with silo", "Mars base 1");
        Picture pictureMarsbase2 = new Picture("marsbase2.jpg","ESA Hotel", "Mars base 2");
        Picture pictureMoon = new Picture("moon.jpg","The place of waving flag", "Moon");
        Picture pictureMosEsley = new Picture("mos_esley.jpg","Han Solo and Luke: The beginning of a beautiful friendship", "mos_esley");
        Picture pictureSaturn = new Picture("saturn.jpg","Giant planet with giant ring", "Saturn");
        Picture pictureTatooine = new Picture("tatooine.jpg","Desert Planet", "Tatooine");
        Picture pictureVenusville = new Picture("venusville.jpg","Total Recall", "Venusville");

        SolarSystem solarSystem1 = new SolarSystem("Milky Way");
        SolarSystem solarSystem2 = new SolarSystem("Star Wars");

        String description1 = "The place where we live";
        String weather1 = "The winter is coming";
        Planet planet1 = new Planet("Mars", description1, weather1, solarSystem1);
        planet1.setPicture(pictureMars);

        String description2 = "Far far away from home";
        String weather2 = "Stormy";
        Planet planet2 = new Planet("Saturn", description2, weather2, solarSystem1);
        planet2.setPicture(pictureSaturn);

        String description3 = "In the neighbourhood";
        String weather3 = "Cold";
        Planet planet3 = new Planet("Moon", description3, weather3, solarSystem1);
        planet3.setPicture(pictureMoon);

        String description4 = "The planet where Luke lived in his childhood";
        String weather4 = "Warm and dry";
        Planet planet4 = new Planet("Tatooine", description4, weather4, solarSystem2);
        planet4.setPicture(pictureTatooine);

        String description5 = "Rocky and hard place";
        String weather5 = "Dry";
        Planet planet5 = new Planet("Geonosis", description5, weather5, solarSystem2);
        planet5.setPicture(pictureGeonosis);

        List<Planet> planetsInMilkyWay = new ArrayList<>();
        planetsInMilkyWay.add(planet1);
        planetsInMilkyWay.add(planet2);
        planetsInMilkyWay.add(planet3);
        solarSystem1.setPlanets(planetsInMilkyWay);

        List<Planet> planetsInStarWars = new ArrayList<>();
        planetsInStarWars.add(planet4);
        planetsInStarWars.add(planet5);
        solarSystem2.setPlanets(planetsInStarWars);

        Accomodation accommodation1 = new Accomodation("Mars base 1", planet1,"Hotel with green plants",pictureMarsbase1);
        Accomodation accommodation2 = new Accomodation("Welcome Hotel", planet1,"ESA Hotel for backpackers", pictureMarsbase2);
        Accomodation accommodation3 = new Accomodation("Come and Maybe go Apartman", planet1,"Very special place in he bizarre Venusville", pictureVenusville);
        Accomodation accommodation4 = new Accomodation("Jabba's palace", planet4, "Iron walls, deep jail cells", pictureJabbaPalace);
        Accomodation accommodation5 = new Accomodation("Mos Esley Cantina", planet4, "Nice music and a lot of guests from all part of the Universe", pictureMosEsley);

        List<Accomodation> accommodationsInMars = new ArrayList<>();
        accommodationsInMars.add(accommodation1);
        accommodationsInMars.add(accommodation2);
        accommodationsInMars.add(accommodation3);
        planet1.setAccomodation(accommodationsInMars);

        List<Accomodation> accommodationsInTatooine = new ArrayList<>();
        accommodationsInTatooine.add(accommodation4);
        accommodationsInTatooine.add(accommodation5);
        planet4.setAccomodation(accommodationsInTatooine);

        RoomType roomType = new RoomType("Single Room",1);
        Room room = new Room(accommodation1,300,roomType);
        Room room2 = new Room(accommodation1,400,roomType);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room2);
        //roomType.setRooms(rooms);
        accommodation1.setRooms(rooms);

        RoomType roomType2 = new RoomType("Family Room", 4);

        Room marsBase2Room1 = new Room(accommodation2, 200, roomType);
        Room marsBase2Room2 = new Room(accommodation2, 200, roomType);
        Room marsBase2Room3 = new Room(accommodation2, 200, roomType);
        Room marsBase2Room4 = new Room(accommodation2, 700, roomType2);
        Room marsBase2Room5 = new Room(accommodation2, 700, roomType2);
        Room marsBase2Room6 = new Room(accommodation2, 700, roomType2);

        List<Room> roomsInMarsBase2 = new ArrayList<>();
        roomsInMarsBase2.add(marsBase2Room1);
        roomsInMarsBase2.add(marsBase2Room2);
        roomsInMarsBase2.add(marsBase2Room3);
        roomsInMarsBase2.add(marsBase2Room4);
        roomsInMarsBase2.add(marsBase2Room5);
        roomsInMarsBase2.add(marsBase2Room6);
        accommodation2.setRooms(roomsInMarsBase2);

        List<Room> roomsToRoomType = new ArrayList<>();
        roomsToRoomType.add(room);
        roomsToRoomType.add(room2);
        roomsToRoomType.add(marsBase2Room1);
        roomsToRoomType.add(marsBase2Room2);
        roomsToRoomType.add(marsBase2Room3);
        roomType.setRooms(roomsToRoomType);

        List<Room> roomsToRoomType2 = new ArrayList<>();
        roomsToRoomType2.add(marsBase2Room4);
        roomsToRoomType2.add(marsBase2Room5);
        roomsToRoomType2.add(marsBase2Room6);
        roomType2.setRooms(roomsToRoomType2);

        Customer testPerson = new Customer("Farkas Bertalan", "Hungary, Budapest, Hősök tere 1.", "berci@freemail.hu", "abcd1234");

        RoomReservation firstReservation = new RoomReservation(testPerson, new Date(), marsBase2Room1);
        RoomReservation secondReservation = new RoomReservation(testPerson, new Date(), marsBase2Room4);
        List<RoomReservation> reservationsOfTestPerson = new ArrayList<>();
        reservationsOfTestPerson.add(firstReservation);
        reservationsOfTestPerson.add(secondReservation);
        testPerson.setRoomReservation(reservationsOfTestPerson);

        List<RoomReservation> reservationsInmarsBase2Room1 = new ArrayList<>();
        reservationsInmarsBase2Room1.add(firstReservation);
        marsBase2Room1.setRoomReservations(reservationsInmarsBase2Room1);

        List<RoomReservation> reservationsInmarsBase2Room4 = new ArrayList<>();
        reservationsInmarsBase2Room4.add(secondReservation);
        marsBase2Room4.setRoomReservations(reservationsInmarsBase2Room4);

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(pictureGeonosis);
        em.persist(pictureJabbaPalace);
        em.persist(pictureMars);
        em.persist(pictureMarsbase1);
        em.persist(pictureMarsbase2);
        em.persist(pictureMoon);
        em.persist(pictureMosEsley);
        em.persist(pictureSaturn);
        em.persist(pictureTatooine);
        em.persist(pictureVenusville);
        em.persist(solarSystem1);
        em.persist(solarSystem2);
        em.persist(planet1);
        em.persist(planet2);
        em.persist(planet3);
        em.persist(planet4);
        em.persist(planet5);
        em.persist(accommodation1);
        em.persist(accommodation2);
        em.persist(accommodation3);
        em.persist(accommodation4);
        em.persist(accommodation5);
        em.persist(roomType);
        em.persist(room);
        em.persist(room2);
        em.persist(roomType2);
        em.persist(marsBase2Room1);
        em.persist(marsBase2Room2);
        em.persist(marsBase2Room3);
        em.persist(marsBase2Room4);
        em.persist(marsBase2Room5);
        em.persist(marsBase2Room6);
        em.persist(testPerson);
        em.persist(firstReservation);
        em.persist(secondReservation);
        transaction.commit();
        System.out.println("Galaxies, planets, accommodations, rooms, test user, reservations saved.");

    }
    public static void main(String[] args) {

        System.out.println("Starting...");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        populateDb(em);

        em.close();
        emf.close();
    }
}
