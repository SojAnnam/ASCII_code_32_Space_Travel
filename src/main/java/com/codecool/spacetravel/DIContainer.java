package com.codecool.spacetravel;

import com.codecool.spacetravel.controller.*;
import com.codecool.spacetravel.datahandler.*;
import com.codecool.spacetravel.validator.CustomerDataValidator;
import com.codecool.spacetravel.validator.RoomReservationDataValidator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DIContainer {

    private EntityManager entityManager;
    private AccDataHandler accDataHandler;
    private AccController accController;
    private CustomerDataValidator customerDataValidator;
    private CustomerDataHandler customerDataHandler;
    private CustomerAccountController customerAccountController;
    private PlanetController planetController;
    private PlanetDataHandler planetDataHandler;
    private PlanetRegistrationController planetRegistrationController;
    private RoomController roomController;
    private RoomDataHandler roomDataHandler;
    private RoomReservationDataValidator roomReservationDataValidator;
    private QueryHandler queryHandler;

    public DIContainer(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        this.entityManager = emf.createEntityManager();
        this.queryHandler =  new QueryHandler(entityManager);
        this.planetDataHandler = new PlanetDataHandler(queryHandler);
        this.planetRegistrationController = new PlanetRegistrationController(planetDataHandler);
        this.planetController = new PlanetController(planetDataHandler);
        this.accDataHandler = new AccDataHandler(queryHandler);
        this.accController = new AccController(accDataHandler);
        this.customerDataValidator = new CustomerDataValidator(queryHandler);
        this.customerDataHandler = new CustomerDataHandler(queryHandler, customerDataValidator);
        this.customerAccountController = new CustomerAccountController(customerDataHandler);
        this.roomReservationDataValidator = new RoomReservationDataValidator();
        this.roomDataHandler = new RoomDataHandler(queryHandler, roomReservationDataValidator);
        this.roomController = new RoomController(roomDataHandler);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public AccDataHandler getAccDataHandler() {
        return accDataHandler;
    }

    public AccController getAccController() {
        return accController;
    }

    public CustomerDataValidator getCustomerDataValidator() {
        return customerDataValidator;
    }

    public CustomerDataHandler getCustomerDataHandler() {
        return customerDataHandler;
    }

    public CustomerAccountController getCustomerAccountController() {
        return customerAccountController;
    }

    public PlanetController getPlanetController() {
        return planetController;
    }

    public PlanetDataHandler getPlanetDataHandler() {
        return planetDataHandler;
    }

    public PlanetRegistrationController getPlanetRegistrationController() {
        return planetRegistrationController;
    }

    public RoomController getRoomController() {
        return roomController;
    }

    public RoomDataHandler getRoomDataHandler() {
        return roomDataHandler;
    }

    public RoomReservationDataValidator getRoomReservationDataValidator() {
        return roomReservationDataValidator;
    }

    public QueryHandler getQueryHandler() {
        return queryHandler;
    }
}
