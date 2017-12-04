package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.RoomReservation;
import com.codecool.spacetravel.validator.CustomerDataValidator;
import spark.Request;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDataHandler{

    private QueryHandler queryHandler;
    private CustomerDataValidator customerDataValidator;

    public CustomerDataHandler(QueryHandler queryHandler, CustomerDataValidator customerDataValidator) {
        this.queryHandler = queryHandler;
        this.customerDataValidator = customerDataValidator;
    }

    public boolean saveCustomerDatas(Map<String, String> customerDatas) {
        boolean savingSucceeded = false;

        Customer customer = new Customer(
                customerDatas.get("firstname"),
                customerDatas.get("lastname"),
                customerDatas.get("email"),
                customerDatas.get("country"),
                customerDatas.get("city"),
                customerDatas.get("postalcode"),
                customerDatas.get("address"),
                customerDatas.get("password")
        );

        List<RoomReservation> reservationsOfCustomer = new ArrayList<>();
        customer.setRoomReservation(reservationsOfCustomer);

        try {
            queryHandler.persistData(customer);
            savingSucceeded = true;
        } catch (Exception e){
            System.out.println("SAVING FAILED: " + e.getMessage());
        }
        return savingSucceeded;
    }

    public Map collectCustomerRegistrationData(Request req) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();
        boolean savingSucceeded = false;
        boolean savingTried = false;

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
                savingTried = true;
                savingSucceeded = saveCustomerDatas(customerDatas);
            }
        }

        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerDatas);
        params.put("errors", errorMessages);
        params.put("savingsucceeded", savingSucceeded);
        params.put("savingtried", savingTried);

        return params;
    }

    public Map collectLoginData(Request req) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();
        Customer customer = null;
        if (req.queryParams().size() > 0){
            customerDatas.put("email", req.queryParams("email"));
            customerDatas.put("password", req.queryParams("password"));

            Map<String, Object> errorMessagesAndCustomer = customerDataValidator.validateLoginDatas(customerDatas);
            errorMessages = (List<String>) errorMessagesAndCustomer.get("errors");
            customer = (Customer) errorMessagesAndCustomer.get("customer");


        }

        Map<String, Object> params = new HashMap<>();
        params.put("customer", customerDatas);
        params.put("errors", errorMessages);
        params.put("validcustomer", customer);

        return  params;
    }

}
