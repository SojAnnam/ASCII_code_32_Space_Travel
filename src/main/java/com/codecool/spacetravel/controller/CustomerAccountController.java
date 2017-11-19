package com.codecool.spacetravel.controller;

import com.codecool.spacetravel.Model.Customer;
import com.codecool.spacetravel.Model.Room;
import com.codecool.spacetravel.Model.RoomReservation;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerAccountController {

    public static Object renderCustomerRegistration(Request req, Response res, EntityManager em) {
        List<String> errorMessages = new ArrayList();
        Map<String, String> userDatas = new HashMap<>();

        if (req.queryParams().size() > 0){
            userDatas.put("name", req.queryParams("name"));
            userDatas.put("email", req.queryParams("email"));
            userDatas.put("country", req.queryParams("country"));
            userDatas.put("city", req.queryParams("city"));
            userDatas.put("postalcode", req.queryParams("postalcode"));
            userDatas.put("address", req.queryParams("address"));
            userDatas.put("password", req.queryParams("password"));
            userDatas.put("confirm", req.queryParams("confirm"));

            errorMessages = validateRegistrationDatas(userDatas);

            if (errorMessages.size() == 0){
                saveCustomerDatas(userDatas, em);
                res.redirect("/customer-registration-succeeded");
            }
        }

        Map params = new HashMap<>();
        params.put("user", userDatas);
        params.put("errors", errorMessages);
        return new ModelAndView(params, "customer_registration");
    }

    private static List<String> validateRegistrationDatas(Map<String, String> userDatas) {
        List<String> errorMessages = new ArrayList();

        if (userDatas.get("name").length() < 5){
            errorMessages.add("Name must be at least 5 character long.");
        }
        if (dataContainsNumber(userDatas.get("name"))){
            errorMessages.add("Human name shall be free of numbers.");
        }
        if (dataContainsSigns(userDatas.get("name"))){
            errorMessages.add("Human name shall be free of signs.");
        }
        if (nameNotContainsTwoNameElement(userDatas.get("name"))){
            errorMessages.add("Type the name in 'firstname lastname' format, e.g. John Doe.");
        }

        System.out.println(userDatas.get("email"));
        Pattern compiledPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = compiledPattern.matcher(userDatas.get("email"));
        boolean emailIsCorrect = matcher.matches();
        System.out.println(emailIsCorrect);
        if (!emailIsCorrect){
            errorMessages.add("Type email in this format: john.doe@fantasymail.com");
        }

        if (userDatas.get("country").length() < 5){
            errorMessages.add("Country must be at least 5 character long.");
        }

        if (dataContainsNumber(userDatas.get("country"))){
            errorMessages.add("Country shall be free of numbers.");
        }

        if (userDatas.get("city").length() < 5){
            errorMessages.add("City must be at least 5 character long.");
        }

        if (dataContainsNumber(userDatas.get("city"))){
            errorMessages.add("City shall be free of numbers.");
        }

        if (userDatas.get("postalcode").length() < 2 || userDatas.get("postalcode").length() > 10){
            errorMessages.add("Postal Code's length must be between 2 and 10 characters.");
        }

        if (userDatas.get("address").length() < 5){
            errorMessages.add("Address must be at least 5 character long.");
        }

        if (userDatas.get("password").length() < 5){
            errorMessages.add("Password must be at least 5 character long.");
        }

        if (!userDatas.get("password").equals(userDatas.get("confirm"))){
            errorMessages.add("Password confirmation failed. Type the same password in Password and Confirm fields.");
        }

        return errorMessages;
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

    private static boolean nameNotContainsTwoNameElement(String name){
        String[] parts = name.split(" ");
        if (parts.length < 2){
            return true;
        }
        return false;
    }


    public static void saveCustomerDatas(Map<String, String> userDatas, EntityManager em) {
        Customer customer = new Customer(
                userDatas.get("name"),
                userDatas.get("email"),
                userDatas.get("country"),
                userDatas.get("city"),
                userDatas.get("postalcode"),
                userDatas.get("address"),
                userDatas.get("password")
        );

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(customer);
        transaction.commit();
    }

}