package com.codecool.spacetravel;

import spark.Request;
import spark.Response;
import spark.template.thymeleaf.ThymeleafTemplateEngine;

import static spark.Spark.get;
import static spark.Spark.post;

public class Routes {
    private DIContainer diContainer;

    public Routes(DIContainer diContainer) {
        this.diContainer = diContainer;
    }

    public void initRoutes() {


        get("/", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetController().renderPlanets(req, res, false));
        });

        get("/customer-registration", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getCustomerAccountController().renderCustomerRegistration(req, res));
        });

        post("/customer-registration", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getCustomerAccountController().renderCustomerRegistration(req, res));
        });

        get("/customer-registration-succeeded", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetController().renderPlanets(req, res, true));
        });

        get("/login", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getCustomerAccountController().renderLogin(req, res));
        });

        post("/login", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getCustomerAccountController().renderLogin(req, res));
        });

        get("/logout", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getCustomerAccountController().renderLogout(req, res));
        });

        get("/registration-planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetRegistrationController().renderPlanetRegistration(req, res));
        });
        post("/registration-planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetRegistrationController().renderPlanetRegistration(req, res));
        });


        get("/planet", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetController().renderPlanets(req, res, false));
        });
        get("/planet/:solarSystemId", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getPlanetController().renderPlanets(req, res, false));
        });

        get("/:planetId/accomodation", (Request req, Response res) -> {
            int planetId = Integer.parseInt(req.params(":planetId"));

            return new ThymeleafTemplateEngine().render(diContainer.getAccController().renderAcc(req, res, planetId));
        });

        get("/reservation/:id", (Request req, Response res) -> {

            return new ThymeleafTemplateEngine().render(diContainer.getRoomController().renderRooms(req, res));
        });

        post("/reservation", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getRoomController().renderRooms(req, res));
        });

        post("/save", (Request req, Response res) -> {
            return new ThymeleafTemplateEngine().render(diContainer.getRoomController().renderRoomReservationSaving(req, res));
        });

    }

}
