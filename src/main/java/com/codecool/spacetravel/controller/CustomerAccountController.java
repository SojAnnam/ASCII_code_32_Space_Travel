package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.controller.collectdata.CustomerDataHandler;
import com.codecool.spacetravel.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class CustomerAccountController {

    @Autowired
    private CustomerDataHandler customerDataHandler;

    @RequestMapping(value = "/customer-registration", method = RequestMethod.GET)
    public String renderCustomerRegistration(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("errors", new ArrayList<>());
        return "customer_registration";
    }

    @RequestMapping(value = "/customer-registration", method = RequestMethod.POST)
    public String renderCustomerRegistration(@ModelAttribute Customer customer,
                                             @RequestParam("confirm") String confirm,
                                             Model model) {

        model = customerDataHandler.collectCustomerRegistrationData(customer, confirm, model);

        List<String> errorMessages = (List) model.asMap().get("errors");

        if (errorMessages.size() == 0 &&
                (boolean) model.asMap().get("savingtried")){
            if ((boolean) model.asMap().get("savingsucceeded")){
                return "redirect:/customer-registration-succeeded";
            } else {
                errorMessages.add("Database problem. Please, try later.");
                model.addAttribute("errors", errorMessages);
            }
        }

        return "customer_registration";

    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String renderLogin(@RequestParam Map<String,String> allRequestParams,
                              Model model,
                              HttpServletRequest httpServletRequest) {
        model = customerDataHandler.collectLoginData(allRequestParams, model);

        List<String> errorMessages = (List) model.asMap().get("errors");
        Customer customer = (Customer) model.asMap().get("validcustomer");

        if (errorMessages.size() == 0 && customer != null){
            httpServletRequest.getSession().setAttribute("customer_id", customer.getId());
            httpServletRequest.getSession().setAttribute("customer_name", customer.getFirstName() + " " + customer.getLastName());
            return "redirect:/";
        }

        return "login";

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String renderLogout(HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute("customer_id");
        httpServletRequest.getSession().removeAttribute("customer_name");
        return "redirect:/";
    }

}
