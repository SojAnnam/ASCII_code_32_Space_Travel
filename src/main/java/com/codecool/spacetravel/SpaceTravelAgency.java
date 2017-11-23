package com.codecool.spacetravel;

import com.codecool.spacetravel.datahandler.*;
import com.codecool.spacetravel.controller.*;

import com.codecool.spacetravel.validator.CustomerDataValidator;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;
import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import javax.persistence.*;

import static spark.Spark.*;
import static spark.debug.DebugScreen.enableDebugScreen;

public class SpaceTravelAgency {

    private EntityManager entityManager;
    private AccDataHandler accDataHandler;
    private AccController accController;
    private CustomerDataValidator customerDataValidator;
    private CustomerDataHandler customerDataHandler;
    private CustomerAccountController customerAccountController;
    private PlanetController planetController;
    private PlanetDataHandler planetDataHandler;
    private PlanetRegistrationController planetRegistrationController;
    private PopulateDatabase populateDatabase;
    private RoomController roomController;
    private RoomDataHandler roomDataHandler;
    private RoomReservationDataValidator roomReservationDataValidator;

    public SpaceTravelAgency(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        this.entityManager = emf.createEntityManager();
        this.populateDatabase = new PopulateDatabase(entityManager);
        this.planetDataHandler = new PlanetDataHandler(entityManager);
        this.planetRegistrationController = new PlanetRegistrationController(planetDataHandler);
        this.planetController = new PlanetController(planetDataHandler);
        this.accDataHandler = new AccDataHandler(entityManager);
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

        spaceTravelAgency.populateDatabase.createEntities();

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

}
