package com.codecool.spacetravel;

import com.codecool.spacetravel.controller.CustomerAccountController;
import com.codecool.spacetravel.datahandler.CustomerDataHandler;
import com.codecool.spacetravel.validator.CustomerDataValidator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DIContainer {

    public void doInject(){

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("spacetravel");
        EntityManager em = emf.createEntityManager();

        /*CustomerDataValidator customerDataValidator = new CustomerDataValidator();
        CustomerDataHandler customerDataHandler = new CustomerDataHandler();
        CustomerAccountController customerAccountController = new CustomerAccountController(customerDataHandler);*/
    }
}
