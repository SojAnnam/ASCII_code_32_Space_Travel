package com.codecool.spacetravel;

import com.codecool.spacetravel.datahandler.AccDataHandler;
import com.codecool.spacetravel.datahandler.CustomerDataHandler;
import com.codecool.spacetravel.datahandler.PlanetDataHandler;
import com.codecool.spacetravel.datahandler.RoomDataHandler;
import com.codecool.spacetravel.model.*;
import com.codecool.spacetravel.controller.*;

import com.codecool.spacetravel.validator.CustomerDataValidator;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class SpaceTravelAgency {

    private PlanetDataHandler planetDataHandler;
    private AccDataHandler accDataHandler;
    private AccController accController;
    private PlanetController planetController;
    private PlanetRegistrationController planetRegistrationController;
    private CustomerDataValidator customerDataValidator;
    private CustomerDataHandler customerDataHandler;
    private CustomerAccountController customerAccountController;
    private EntityManager entityManager;
    private RoomController roomController;
    private RoomDataHandler roomDataHandler;
    private RoomReservationDataValidator roomReservationDataValidator;

    public SpaceTravelAgency(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        this.entityManager = emf.createEntityManager();
        this.accDataHandler = new AccDataHandler(entityManager);
        this.planetDataHandler = new PlanetDataHandler(entityManager);
        this.planetRegistrationController = new PlanetRegistrationController(planetDataHandler);
        this.planetController = new PlanetController(planetDataHandler);
        this.accController = new AccController(planetDataHandler, accDataHandler);
        this.customerDataHandler = new CustomerDataHandler(entityManager);
        this.customerDataValidator = new CustomerDataValidator(customerDataHandler);
        this.customerAccountController = new CustomerAccountController(customerDataValidator, customerDataHandler);
        this.roomReservationDataValidator = new RoomReservationDataValidator();
        this.roomDataHandler = new RoomDataHandler(entityManager);
        this.roomController = new RoomController(roomDataHandler, roomReservationDataValidator);
    }

    public static void main(String[] args) {

        /*
        DIContainer di = new ..
        MainClass cl = di.doInject();
        cl.start()

        DI CONTAINER:

        doInject function:
        EntityManager em = new...
        PlanetDH = new PlanetDH(em)
        PlanetController pc = new PlanetController(planetDH)



         */

        SpaceTravelAgency spaceTravelAgency = new SpaceTravelAgency();


        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        // Add this line to your project to enable the debug screen
        enableDebugScreen();

        System.out.println("Starting...");

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();*/

        spaceTravelAgency.populateDb();

        get("/", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetController.renderPlanets(req, res, false));
        });

        get("/customer-registration", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.customerAccountController.renderCustomerRegistration(req, res));
        });

        post("/customer-registration", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.customerAccountController.renderCustomerRegistration(req, res));
        });

        get("/customer-registration-succeeded", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetController.renderPlanets(req, res, true));
        });

        get("/login", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.customerAccountController.renderLogin(req, res));
        });

        post("/login", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.customerAccountController.renderLogin(req, res));
        });

        get("/logout", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.customerAccountController.renderLogout(req, res));
        });

        get("/registration-planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetRegistrationController.renderPlanetRegistration(req, res));
        });
        post("/registration-planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetRegistrationController.renderPlanetRegistration(req, res));
        });


        get("/planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetController.renderPlanets(req, res, false));
        });
        get("/planet/:solarSystemId", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.planetController.renderPlanets(req, res, false));
        });

        get("/:planetId/accomodation", (Request req, Response res) -> {
            int planetId = Integer.parseInt(req.params(":planetId"));

            return new ThymeleafTemplateEngine().render(spaceTravelAgency.accController.renderAcc(req, res, planetId));
        });

        get("/reservation/:id", (Request req, Response res) -> {
            /*int id = Integer.parseInt(req.params(":id"));
            System.out.println("ID: " + id);*/
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.roomController.renderRooms(req, res));
        });

        post("/reservation", (Request req, Response res) ->{
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.roomController.renderRooms(req, res));
        });

        post("/save", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(spaceTravelAgency.roomController.renderRoomReservationSaving(req, res));
        });

    }


    private void populateDb() {

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

        String description1 = "The place where we live. Mars is the fourth planet from the Sun and the second-smallest planet in the Solar System after Mercury. Mars's average distance from the Sun is roughly 230 million kilometres. Orbital period is 687 (Earth) days.";
        String weather1 = "The winter is coming...Average temperature is about -60 C°, although it can vary from -125 C° near the poles during the winter to as much as a comfortable 20 C° at midday near the equator.";
        Planet planet1 = new Planet("Mars", description1, weather1, solarSystem1);
        planet1.setPicture(pictureMars);

        String description2 = "Far far away from home. Saturn is the sixth planet from the Sun and the second-largest in the Solar System.The planet's most famous feature is its prominent ring system that is composed mostly of ice particles, rocky debris and dust. ";
        String weather2 = "Pretty violent and stormy!";
        Planet planet2 = new Planet("Saturn", description2, weather2, solarSystem1);
        planet2.setPicture(pictureSaturn);

        String description3 = "In the neighbourhood.";
        String weather3 = "Daytime temperatures on the sunny side of the moon reach 273 degrees F (134 C°); on the dark side it gets as cold as minus 243 F (minus 153 C°).";
        Planet planet3 = new Planet("Moon", description3, weather3, solarSystem1);
        planet3.setPicture(pictureMoon);

        String description4 = "Tatooine was a sparsely inhabited circumbinary desert planet located in the galaxy's Outer Rim Territories. It would serve as the homeworld to the influential Anakin and Luke Skywalker, who would go on to shape galactic history.";
        String weather4 = "Warm and dry";
        Planet planet4 = new Planet("Tatooine", description4, weather4, solarSystem2);
        planet4.setPicture(pictureTatooine);

        String description5 = "Rocky and hard place.Situated in the Geonosis system of the Arkanis sector in the Outer Rim Territories, the planet of Geonosis was 43,000 light years from the Galactic Core, and less than a parsec away from the Outer Rim planet of Tatooine.";
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

        Accomodation accommodation1 = new Accomodation("Mars base 1", planet1,"Hotel with green plants. On every morning we offer you to taste fresh veggies. Enjoy the long walk in the first Martian greenhouse!",pictureMarsbase1);
        Accomodation accommodation2 = new Accomodation("Welcome Hotel", planet1,"ESA Hotel for backpackers. Since the dawn of the space age, Mars has been the target of orbiters, landers and rovers. And now for the backpackers! We offer a multicultural atmosphere, many cultural programs are available.", pictureMarsbase2);
        Accomodation accommodation3 = new Accomodation("Come and Maybe Go Apartman", planet1,"A very special place in the bizarre Venusville", pictureVenusville);
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
        RoomType roomType2 = new RoomType("King's Suite", 4);
        RoomType roomType3 = new RoomType("Family Room", 10);
        RoomType roomType4 = new RoomType("Honeymoon Suite", 2);
        RoomType roomType5 = new RoomType("Double Room", 2);

        Room room1Acc1 = new Room(accommodation1,300,roomType5);
        Room room2Acc1 = new Room(accommodation1,600,roomType2);
        Room room3Acc1 = new Room(accommodation1,2500,roomType3);
        Room room4Acc1 = new Room(accommodation1,2500,roomType3);
        Room room5Acc1 = new Room(accommodation1,1000,roomType4);

        Room room1Acc4 = new Room(accommodation4,300,roomType);
        Room room2Acc4 = new Room(accommodation4,1000,roomType2);
        Room room3Acc4 = new Room(accommodation4,600,roomType5);
        Room room4Acc4 = new Room(accommodation4,800,roomType4);

        List<Room> rooms = new ArrayList<>();
        rooms.add(room1Acc1);
        rooms.add(room2Acc1);
        rooms.add(room3Acc1);
        rooms.add(room4Acc1);
        rooms.add(room5Acc1);
        //roomType.setRooms(rooms);
        accommodation1.setRooms(rooms);

        List<Room> roomsAcc4 = new ArrayList<>();
        roomsAcc4.add(room1Acc4);
        roomsAcc4.add(room2Acc4);
        roomsAcc4.add(room3Acc4);
        roomsAcc4.add(room4Acc4);
        accommodation4.setRooms(roomsAcc4);

        Room marsBase2Room1 = new Room(accommodation2, 200, roomType);
        Room marsBase2Room2 = new Room(accommodation2, 600, roomType5);
        Room marsBase2Room3 = new Room(accommodation2, 800, roomType4);
        Room marsBase2Room4 = new Room(accommodation2, 1000, roomType2);
        Room marsBase2Room5 = new Room(accommodation2, 1000, roomType2);
        Room marsBase2Room6 = new Room(accommodation2, 2000, roomType3);

        List<Room> roomsInMarsBase2 = new ArrayList<>();
        roomsInMarsBase2.add(marsBase2Room1);
        roomsInMarsBase2.add(marsBase2Room2);
        roomsInMarsBase2.add(marsBase2Room3);
        roomsInMarsBase2.add(marsBase2Room4);
        roomsInMarsBase2.add(marsBase2Room5);
        roomsInMarsBase2.add(marsBase2Room6);
        accommodation2.setRooms(roomsInMarsBase2);

        List<Room> roomsToRoomType = new ArrayList<>();
        roomsToRoomType.add(marsBase2Room1);
        roomsToRoomType.add(room1Acc4);
        roomType.setRooms(roomsToRoomType);

        List<Room> roomsToRoomType2 = new ArrayList<>();
        roomsToRoomType2.add(room2Acc1);
        roomsToRoomType2.add(marsBase2Room4);
        roomsToRoomType2.add(marsBase2Room5);
        roomsToRoomType2.add(room2Acc4);
        roomType2.setRooms(roomsToRoomType2);

        List<Room> roomsToRoomType3 = new ArrayList<>();
        roomsToRoomType3.add(room3Acc1);
        roomsToRoomType3.add(room4Acc1);
        roomsToRoomType3.add(marsBase2Room6);
        roomType3.setRooms(roomsToRoomType3);

        List<Room> roomsToRoomType4 = new ArrayList<>();
        roomsToRoomType4.add(room5Acc1);
        roomsToRoomType4.add(marsBase2Room3);
        roomsToRoomType4.add(room4Acc4);
        roomType4.setRooms(roomsToRoomType4);

        List<Room> roomsToRoomType5 = new ArrayList<>();
        roomsToRoomType5.add(room1Acc1);
        roomsToRoomType5.add(marsBase2Room2);
        roomsToRoomType5.add(room3Acc4);
        roomType5.setRooms(roomsToRoomType5);

        Customer admin = new Customer("admin", "admin", "admin", "Hungary",
                "Budapest", "1140", "Várkert bazár 1.", "admin");
        List<RoomReservation> reservationsOfAdmin = new ArrayList<>();
        admin.setRoomReservation(reservationsOfAdmin);

        Customer testPerson = new Customer("Bertalan", "Farkas", "berci@freemail.hu", "Hungary",
                "Budapest", "1140", "Hősök tere 1.", "abcd1234");

        String startDateString = "2017/12/10";
        String endDateString = "2017/12/20";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(startDateString);
            endDate = dateFormat.parse(endDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        RoomReservation firstReservation = new RoomReservation(testPerson, startDate, endDate, marsBase2Room1);
        RoomReservation secondReservation = new RoomReservation(testPerson, startDate, endDate, marsBase2Room4);
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

        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(pictureGeonosis);
        entityManager.persist(pictureJabbaPalace);
        entityManager.persist(pictureMars);
        entityManager.persist(pictureMarsbase1);
        entityManager.persist(pictureMarsbase2);
        entityManager.persist(pictureMoon);
        entityManager.persist(pictureMosEsley);
        entityManager.persist(pictureSaturn);
        entityManager.persist(pictureTatooine);
        entityManager.persist(pictureVenusville);
        entityManager.persist(solarSystem1);
        entityManager.persist(solarSystem2);
        entityManager.persist(planet1);
        entityManager.persist(planet2);
        entityManager.persist(planet3);
        entityManager.persist(planet4);
        entityManager.persist(planet5);
        entityManager.persist(accommodation1);
        entityManager.persist(accommodation2);
        entityManager.persist(accommodation3);
        entityManager.persist(accommodation4);
        entityManager.persist(accommodation5);
        entityManager.persist(roomType);
        entityManager.persist(roomType2);
        entityManager.persist(roomType3);
        entityManager.persist(roomType4);
        entityManager.persist(roomType5);
        entityManager.persist(room1Acc1);
        entityManager.persist(room2Acc1);
        entityManager.persist(room3Acc1);
        entityManager.persist(room4Acc1);
        entityManager.persist(room5Acc1);
        entityManager.persist(room1Acc4);
        entityManager.persist(room2Acc4);
        entityManager.persist(room3Acc4);
        entityManager.persist(room4Acc4);
        entityManager.persist(marsBase2Room1);
        entityManager.persist(marsBase2Room2);
        entityManager.persist(marsBase2Room3);
        entityManager.persist(marsBase2Room4);
        entityManager.persist(marsBase2Room5);
        entityManager.persist(marsBase2Room6);
        entityManager.persist(admin);
        entityManager.persist(testPerson);
        entityManager.persist(firstReservation);
        entityManager.persist(secondReservation);
        transaction.commit();
        System.out.println("Galaxies, planets, accommodations, rooms, test user, reservations saved.");
        
    }

}
