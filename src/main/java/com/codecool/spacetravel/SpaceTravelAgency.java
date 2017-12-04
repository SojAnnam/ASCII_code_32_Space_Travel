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

    public static void main(String[] args) {

        // default server settings
        exception(Exception.class, (e, req, res) -> e.printStackTrace());
        staticFileLocation("/public");
        port(8888);

        // Add this line to your project to enable the debug screen
        enableDebugScreen();

        System.out.println("Starting...");

        DIContainer diContainer = new DIContainer();
        Routes routes = new Routes(diContainer);

    }

}
