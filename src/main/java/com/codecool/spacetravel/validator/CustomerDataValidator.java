package com.codecool.spacetravel.validator;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerDataValidator {

    private QueryHandler queryHandler;

    public CustomerDataValidator(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    public List<String> validateRegistrationDatas(Map<String, String> customerDatas) {
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

        if (emailExists(customerDatas.get("email"))){
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

    private boolean dataNotStartsWithUpperCaseLetter(String word) {
        return Character.isLowerCase(word.charAt(0));
    }

    private boolean emailExists(String email) {
        boolean emailExists = false;
        Customer customer = queryHandler.getCustomerByEmail(email);
        if (customer != null){
            emailExists = true;
        }
        return emailExists;
    }

    private boolean dataContainsNumber(String name) {
        String numbers = "1234567890";
        for (int index = 0; index < name.length(); index++){
            if (numbers.contains(Character.toString(name.charAt(index)))){
                return true;
            }
        }
        return false;
    }

    private boolean dataContainsSigns(String name) {
        String signs = ".,;/=*-";
        for (int index = 0; index < name.length(); index++){
            if (signs.contains(Character.toString(name.charAt(index)))){
                return true;
            }
        }
        return false;
    }

    public Map<String, Object> validateLoginDatas(Map<String, String> customerDatas) {
        String email = customerDatas.get("email");
        String password = customerDatas.get("password");

        List<String> errorMessages = new ArrayList();

        Customer customerFromDB = queryHandler.getCustomerByEmail(email);

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
}