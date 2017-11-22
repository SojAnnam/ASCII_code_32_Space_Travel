package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.RoomReservation;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerAccountController {

    public static ModelAndView renderCustomerRegistration(Request req, Response res, EntityManager em) {
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

            errorMessages = validateRegistrationDatas(customerDatas, em);

            if (errorMessages.size() == 0){
                boolean savingSucceeded = saveCustomerDatas(customerDatas, em);
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

    private static List<String> validateRegistrationDatas(Map<String, String> customerDatas, EntityManager em) {
        List<String> errorMessages = new ArrayList();

        if (customerDatas.get("firstname").length() < 2){
            errorMessages.add("First name must be at least 2 character long.");
        }
        if (dataContainsNumber(customerDatas.get("firstname"))){
            errorMessages.add("First name shall be free of numbers.");
        }
        if (dataContainsSigns(customerDatas.get("firstname"))){
            errorMessages.add("First name shall be free of signs.");
        }
        if (customerDatas.get("firstname").length() > 0 && dataNotStartsWithUpperCaseLetter(customerDatas.get("firstname"))){
            errorMessages.add("First name must start with upper case letter.");
        }
        if (customerDatas.get("lastname").length() < 2){
            errorMessages.add("Last name must be at least 2 character long.");
        }
        if (dataContainsNumber(customerDatas.get("lastname"))){
            errorMessages.add("Last name shall be free of numbers.");
        }
        if (dataContainsSigns(customerDatas.get("lastname"))){
            errorMessages.add("Last name shall be free of signs.");
        }
        if (customerDatas.get("lastname").length() > 0 && dataNotStartsWithUpperCaseLetter(customerDatas.get("lastname"))){
            errorMessages.add("Last name must start with upper case letter.");
        }

        Pattern compiledPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = compiledPattern.matcher(customerDatas.get("email"));
        boolean emailIsCorrect = matcher.matches();
        if (!emailIsCorrect){
            errorMessages.add("Type email in this format: john.doe@fantasymail.com");
        }

        if (emailExists(customerDatas.get("email"), em)){
            errorMessages.add("This email is already exists in our database. Give another one.");
        }

        if (customerDatas.get("country").length() < 5){
            errorMessages.add("Country must be at least 5 character long.");
        }

        if (dataContainsNumber(customerDatas.get("country"))){
            errorMessages.add("Country shall be free of numbers.");
        }

        if (customerDatas.get("city").length() < 5){
            errorMessages.add("City must be at least 5 character long.");
        }

        if (dataContainsNumber(customerDatas.get("city"))){
            errorMessages.add("City shall be free of numbers.");
        }

        if (customerDatas.get("postalcode").length() < 2 || customerDatas.get("postalcode").length() > 10){
            errorMessages.add("Postal Code's length must be between 2 and 10 characters.");
        }

        if (customerDatas.get("address").length() < 5){
            errorMessages.add("Address must be at least 5 character long.");
        }

        if (customerDatas.get("password").length() < 5){
            errorMessages.add("Password must be at least 5 character long.");
        }

        if (!customerDatas.get("password").equals(customerDatas.get("confirm"))){
            errorMessages.add("Password confirmation failed. Type the same password in Password and Confirm fields.");
        }

        return errorMessages;
    }

    private static boolean dataNotStartsWithUpperCaseLetter(String word) {
        return Character.isLowerCase(word.charAt(0));
    }

    private static boolean emailExists(String email, EntityManager em) {
        boolean emailExists = false;
        Customer customer = QueryController.getCustomerByEmail(email, em);
        if (customer != null){
            emailExists = true;
        }
        return emailExists;
    }

    private static boolean dataContainsNumber(String name) {
        String numbers = "1234567890";
        for (int index = 0; index < name.length(); index++){
            if (numbers.contains(Character.toString(name.charAt(index)))){
                return true;
            }
        }
        return false;
    }

    private static boolean dataContainsSigns(String name) {
        String signs = ".,;/=*-";
        for (int index = 0; index < name.length(); index++){
            if (signs.contains(Character.toString(name.charAt(index)))){
                return true;
            }
        }
        return false;
    }

    public static boolean saveCustomerDatas(Map<String, String> customerDatas, EntityManager em) {
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

        try{
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.persist(customer);
            transaction.commit();
            savingSucceeded = true;
        } catch (Exception e){
            System.out.println("Saving failed: " + e.getMessage());
        }
        return savingSucceeded;
    }

    public static ModelAndView renderLogin(Request req, Response res, EntityManager em) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> customerDatas = new HashMap<>();

        if (req.queryParams().size() > 0){
            customerDatas.put("email", req.queryParams("email"));
            customerDatas.put("password", req.queryParams("password"));

            Map<String, Object> errorMessagesAndCustomer = validateLoginDatas(customerDatas, em);
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

    private static Map<String, Object> validateLoginDatas(Map<String, String> customerDatas, EntityManager em) {
        String email = customerDatas.get("email");
        String password = customerDatas.get("password");

        List<String> errorMessages = new ArrayList();

        Customer customerFromDB = QueryController.getCustomerByEmail(email, em);

        if (customerFromDB == null) {
            errorMessages.add("Invalid email or password.");
        } else {
            if (!password.equals(customerFromDB.getPassword())) {
                errorMessages.add("Invalid email or password.");
            }
        }

        Map<String, Object> result = new HashMap<>();
        result.put("errors", errorMessages);
        result.put("customer", customerFromDB);
        return result;
    }

    public static ModelAndView renderLogout(Request req, Response res, EntityManager em) {
        req.session().removeAttribute("customer_id");
        req.session().removeAttribute("customer_name");
        res.redirect("/");
        return null;
    }

}