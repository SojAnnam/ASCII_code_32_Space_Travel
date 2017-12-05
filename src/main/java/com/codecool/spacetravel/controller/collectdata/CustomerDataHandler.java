package com.codecool.spacetravel.controller.collectdata;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.RoomReservation;
import com.codecool.spacetravel.service.CustomerDataValidator;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
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
            queryHandler.saveNewCustomer(customer);
            savingSucceeded = true;
        } catch (Exception e){
            System.out.println("SAVING FAILED: " + e.getMessage());
        }
        return savingSucceeded;
    }

    public Model collectCustomerRegistrationData(@RequestParam Map<String,String> allRequestParams,
                                               Model model) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();
        boolean savingSucceeded = false;
        boolean savingTried = false;

        if (allRequestParams.size() > 0){
            customerDatas.put("firstname", allRequestParams.get("firstname"));
            customerDatas.put("lastname", allRequestParams.get("lastname"));
            customerDatas.put("email", allRequestParams.get("email"));
            customerDatas.put("country", allRequestParams.get("country"));
            customerDatas.put("city", allRequestParams.get("city"));
            customerDatas.put("postalcode", allRequestParams.get("postalcode"));
            customerDatas.put("address", allRequestParams.get("address"));
            customerDatas.put("password", allRequestParams.get("password"));
            customerDatas.put("confirm", allRequestParams.get("confirm"));

            errorMessages = customerDataValidator.validateRegistrationDatas(customerDatas);

            if (errorMessages.size() == 0){
                savingTried = true;
                savingSucceeded = saveCustomerDatas(customerDatas);
            }
        } else {
            customerDatas.put("firstname", "");
            customerDatas.put("lastname", "");
            customerDatas.put("email", "");
            customerDatas.put("country", "");
            customerDatas.put("city", "");
            customerDatas.put("postalcode", "");
            customerDatas.put("address", "");
            customerDatas.put("password", "");
            customerDatas.put("confirm", "");
        }


        model.addAttribute("customer", customerDatas);
        model.addAttribute("errors", errorMessages);
        model.addAttribute("savingsucceeded", savingSucceeded);
        model.addAttribute("savingtried", savingTried);

        return model;
    }

    public Model collectLoginData(@RequestParam Map<String,String> allRequestParams,
                                Model model) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();
        Customer customer = null;
        if (allRequestParams.size() > 0){
            customerDatas.put("email", allRequestParams.get("email"));
            customerDatas.put("password", allRequestParams.get("password"));

            Map<String, Object> errorMessagesAndCustomer = customerDataValidator.validateLoginDatas(customerDatas);
            errorMessages = (List<String>) errorMessagesAndCustomer.get("errors");
            customer = (Customer) errorMessagesAndCustomer.get("customer");

        }

        model.addAttribute("customer", customerDatas);
        model.addAttribute("errors", errorMessages);
        model.addAttribute("validcustomer", customer);

        return model;
    }

}
