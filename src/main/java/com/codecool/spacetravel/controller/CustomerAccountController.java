package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.datahandler.CustomerDataHandler;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.validator.CustomerDataValidator;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;


public class CustomerAccountController {

    private CustomerDataValidator customerDataValidator;
    private CustomerDataHandler customerDataHandler;

    public CustomerAccountController(CustomerDataValidator customerDataValidator, CustomerDataHandler customerDataHandler) {
        this.customerDataValidator = customerDataValidator;
        this.customerDataHandler = customerDataHandler;
    }

    public ModelAndView renderCustomerRegistration(Request req, Response res) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();

        if (req.queryParams().size() > 0){
            customerDatas.put("firstname", req.queryParams("firstname"));
            customerDatas.put("lastname", req.queryParams("lastname"));
            customerDatas.put("email", req.queryParams("email"));
            customerDatas.put("country", req.queryParams("country"));
            customerDatas.put("city", req.queryParams("city"));
            customerDatas.put("postalcode", req.queryParams("postalcode"));
            customerDatas.put("address", req.queryParams("address"));
            customerDatas.put("password", req.queryParams("password"));
            customerDatas.put("confirm", req.queryParams("confirm"));

            errorMessages = customerDataValidator.validateRegistrationDatas(customerDatas);

            if (errorMessages.size() == 0){
                boolean savingSucceeded = customerDataHandler.saveCustomerDatas(customerDatas);
                if (savingSucceeded){
                    res.redirect("/customer-registration-succeeded");
                } else {
                    errorMessages.add("Database problem. Please, try later.");
                }
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerDatas);
        params.put("errors", errorMessages);
        return new ModelAndView(params, "customer_registration");
    }

    public ModelAndView renderLogin(Request req, Response res) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();

        if (req.queryParams().size() > 0){
            customerDatas.put("email", req.queryParams("email"));
            customerDatas.put("password", req.queryParams("password"));

            Map<String, Object> errorMessagesAndCustomer = customerDataValidator.validateLoginDatas(customerDatas);
            errorMessages = (List<String>) errorMessagesAndCustomer.get("errors");
            Customer customer = (Customer) errorMessagesAndCustomer.get("customer");

            if (errorMessages.size() == 0 && customer != null){
                req.session().attribute("customer_id", customer.getId());
                req.session().attribute("customer_name", customer.getFirstName() + " " + customer.getLastName());
                res.redirect("/");
                return null;
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerDatas);
        params.put("errors", errorMessages);
        return new ModelAndView(params, "login");

    }

    public ModelAndView renderLogout(Request req, Response res) {
        req.session().removeAttribute("customer_id");
        req.session().removeAttribute("customer_name");
        res.redirect("/");
        return null;
    }

}