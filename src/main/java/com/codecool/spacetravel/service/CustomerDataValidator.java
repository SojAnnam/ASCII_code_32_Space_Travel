package com.codecool.spacetravel.service;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CustomerDataValidator {

    private QueryHandler queryHandler;

    public CustomerDataValidator(QueryHandler queryHandler) {
        this.queryHandler = queryHandler;
    }

    public List<String> validateRegistrationDatas(Customer customer, String confirm) {
        List<String> errorMessages = new ArrayList();

        if (customer.getFirstName().length() < 2){
            errorMessages.add("First name must be at least 2 character long.");
        }
        if (dataContainsNumber(customer.getFirstName())){
            errorMessages.add("First name shall be free of numbers.");
        }
        if (dataContainsSigns(customer.getFirstName())){
            errorMessages.add("First name shall be free of signs.");
        }
        if (customer.getFirstName().length() > 0 && dataNotStartsWithUpperCaseLetter(customer.getFirstName())){
            errorMessages.add("First name must start with upper case letter.");
        }
        if (customer.getLastName().length() < 2){
            errorMessages.add("Last name must be at least 2 character long.");
        }
        if (dataContainsNumber(customer.getLastName())){
            errorMessages.add("Last name shall be free of numbers.");
        }
        if (dataContainsSigns(customer.getLastName())){
            errorMessages.add("Last name shall be free of signs.");
        }
        if (customer.getLastName().length() > 0 && dataNotStartsWithUpperCaseLetter(customer.getLastName())){
            errorMessages.add("Last name must start with upper case letter.");
        }

        Pattern compiledPattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = compiledPattern.matcher(customer.getEmail());
        boolean emailIsCorrect = matcher.matches();
        if (!emailIsCorrect){
            errorMessages.add("Type email in this format: john.doe@fantasymail.com");
        }

        if (emailExists(customer.getEmail())){
            errorMessages.add("This email is already exists in our database. Give another one.");
        }

        if (customer.getCountry().length() < 3){
            errorMessages.add("Country must be at least 3 character long.");
        }

        if (dataContainsNumber(customer.getCountry())){
            errorMessages.add("Country shall be free of numbers.");
        }

        if (customer.getCity().length() < 2){
            errorMessages.add("City must be at least 2 character long.");
        }

        if (dataContainsNumber(customer.getCity())){
            errorMessages.add("City shall be free of numbers.");
        }

        if (customer.getPostalCode().length() < 2 || customer.getPostalCode().length() > 10){
            errorMessages.add("Postal Code's length must be between 2 and 10 characters.");
        }

        if (customer.getAddress().length() < 5){
            errorMessages.add("Address must be at least 5 character long.");
        }

        if (customer.getPassword().length() < 5){
            errorMessages.add("Password must be at least 5 character long.");
        }

        if (!customer.getPassword().equals(confirm)){
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