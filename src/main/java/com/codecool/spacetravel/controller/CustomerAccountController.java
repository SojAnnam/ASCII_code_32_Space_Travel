package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.CustomerDataHandler;
import com.codecool.spacetravel.model.Customer;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;


public class CustomerAccountController {

    private CustomerDataHandler customerDataHandler;

    public CustomerAccountController(CustomerDataHandler customerDataHandler) {
        this.customerDataHandler = customerDataHandler;
    }

    public ModelAndView renderCustomerRegistration(Request req, Response res) {
        Map params = customerDataHandler.collectCustomerRegistrationData(req);

        List<String> errorMessages = (List) params.get("errors");

        if (errorMessages.size() == 0 &&
                (boolean) params.get("savingtried")){
            if ((boolean) params.get("savingsucceeded")){
                res.redirect("/customer-registration-succeeded");
            } else {
                errorMessages.add("Database problem. Please, try later.");
            }
        }

        return new ModelAndView(params, "customer_registration");
    }

    public ModelAndView renderLogin(Request req, Response res) {
        Map params = customerDataHandler.collectLoginData(req);

        List<String> errorMessages = (List) params.get("errors");
        Customer customer = (Customer) params.get("validcustomer");

        if (errorMessages.size() == 0 && customer != null){
            req.session().attribute("customer_id", customer.getId());
            req.session().attribute("customer_name", customer.getFirstName() + " " + customer.getLastName());
            res.redirect("/");
            return null;
        }

        return new ModelAndView(params, "login");

    }

    public ModelAndView renderLogout(Request req, Response res) {
        req.session().removeAttribute("customer_id");
        req.session().removeAttribute("customer_name");
        res.redirect("/");
        return null;
    }

}