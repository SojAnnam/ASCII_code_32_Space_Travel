package com.codecool.spacetravel;

import com.codecool.spacetravel.Model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void populateDb(EntityManager em) {


        SolarSystem solarSystem = new SolarSystem();

        Planet mars = new Planet();

        Accomodation marsAcc = new Accomodation();

        RoomType roomType = new RoomType("Single Room",1);
        Room room = new Room(marsAcc,300,roomType);
        Room room2 = new Room(marsAcc,400,roomType);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room);
        rooms.add(room2);
        roomType.setRooms(rooms);
        marsAcc.setRooms(rooms);




        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(solarSystem);
        em.persist(mars);
        em.persist(marsAcc);
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
