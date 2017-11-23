package com.codecool.spacetravel.validator;

import com.codecool.spacetravel.datahandler.QueryHandler;
import com.codecool.spacetravel.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CustomerDataValidatorTest {

    private static Map<String, String> exampleCorrectCustomerDatas = createGoodCustomerDatas();
    private static Map<String, String> exampleBadCustomerDatasWrongConfirm = createBadCustomerDatasWrongConfirm();
    private static Map<String, String> exampleBadCustomerDatasFourWrongData = createBadCustomerDatasFourWrongData();
    private static Customer exampleCustomer = new Customer("Arnold", "Schwarzenegger",
            "arnold@freemail.hu", "United States", "Los Angeles",
            "90001", "Workout avenue 1.", "terminator");
    private static Map<String, String> exampleGoodLoginDatas = createGoodLoginDatas();
    private static Map<String, String> exampleBadLoginDatasWrongPassword = createBadLoginDatasWrongPassword();

    private static Map<String,String> createGoodCustomerDatas() {
        Map<String, String> exampleCorrectCustomerDatas = new HashMap<>();
        exampleCorrectCustomerDatas.put("firstname", "Arnold");
        exampleCorrectCustomerDatas.put("lastname", "Schwarzenegger");
        exampleCorrectCustomerDatas.put("email", "arnold@freemail.hu");
        exampleCorrectCustomerDatas.put("country", "United States");
        exampleCorrectCustomerDatas.put("city", "Los Angeles");
        exampleCorrectCustomerDatas.put("postalcode", "90001");
        exampleCorrectCustomerDatas.put("address", "Workout avenue 1.");
        exampleCorrectCustomerDatas.put("password", "terminator");
        exampleCorrectCustomerDatas.put("confirm", "terminator");
        return exampleCorrectCustomerDatas;
    }

    private static Map<String,String> createBadCustomerDatasWrongConfirm() {
        Map<String, String> exampleBadCustomerDatas = new HashMap<>();
        exampleBadCustomerDatas.put("firstname", "Arnold");
        exampleBadCustomerDatas.put("lastname", "Schwarzenegger");
        exampleBadCustomerDatas.put("email", "arnold@freemail.hu");
        exampleBadCustomerDatas.put("country", "United States");
        exampleBadCustomerDatas.put("city", "Los Angeles");
        exampleBadCustomerDatas.put("postalcode", "90001");
        exampleBadCustomerDatas.put("address", "Workout avenue 1.");
        exampleBadCustomerDatas.put("password", "terminator");
        exampleBadCustomerDatas.put("confirm", "loser");
        return exampleBadCustomerDatas;
    }

    private static Map<String,String> createBadCustomerDatasFourWrongData() {
        Map<String, String> exampleCorrectCustomerDatas = new HashMap<>();
        exampleCorrectCustomerDatas.put("firstname", ""); // missing first name
        exampleCorrectCustomerDatas.put("lastname", "Schwarz;enegger"); // sign in human last name
        exampleCorrectCustomerDatas.put("email", "missingdothu@freemail"); // missing .hu, .com etc. element
        exampleCorrectCustomerDatas.put("country", "Unit6 States"); // number in country name
        exampleCorrectCustomerDatas.put("city", "Los Angeles");
        exampleCorrectCustomerDatas.put("postalcode", "90001");
        exampleCorrectCustomerDatas.put("address", "Workout avenue 1.");
        exampleCorrectCustomerDatas.put("password", "terminator");
        exampleCorrectCustomerDatas.put("confirm", "terminator");
        return exampleCorrectCustomerDatas;
    }

    private static Map<String,String> createGoodLoginDatas() {
        Map<String, String> exampleCorrectLoginDatas = new HashMap<>();
        exampleCorrectLoginDatas.put("email", "arnold@freemail.hu");
        exampleCorrectLoginDatas.put("password", "terminator");
        return exampleCorrectLoginDatas;
    }

    private static Map<String,String> createBadLoginDatasWrongPassword() {
        Map<String, String> exampleBadLoginDatas = new HashMap<>();
        exampleBadLoginDatas.put("email", "arnold@freemail.hu");
        exampleBadLoginDatas.put("password", "iamweak");
        return exampleBadLoginDatas;
    }

    @Test
    void validateRegistrationDatas_GoodDatas_NoErrorMessages() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        List<String> errorMessages = customerDataValidator.validateRegistrationDatas(exampleCorrectCustomerDatas);
        assertEquals(errorMessages.size(), 0);
    }

    @Test
    void validateRegistrationDatas_BadConfirm_OneErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        List<String> errorMessages = customerDataValidator
                .validateRegistrationDatas(exampleBadCustomerDatasWrongConfirm);
        assertEquals(errorMessages.size(), 1);
        assertEquals(errorMessages.get(0),
                "Password confirmation failed. Type the same password in Password and Confirm fields.");
    }

    @Test
    void validateRegistrationDatas_BadDatas_FourErrorMessages() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        List<String> errorMessages = customerDataValidator
                .validateRegistrationDatas(exampleBadCustomerDatasFourWrongData);
        assertEquals(errorMessages.size(), 4);
    }

    @Test
    void validateLoginDatas_EmailAddressFoundedInDatabasePasswordIsGood_NoErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String exampleGoodEmail = "arnold@freemail.hu";
        when(queryHandlerMock.getCustomerByEmail(exampleGoodEmail)).thenReturn(exampleCustomer);
        List<String> errorMessages = (ArrayList) customerDataValidator
                .validateLoginDatas(exampleGoodLoginDatas).get("errors");
        assertEquals(0, errorMessages.size());
    }


    @Test
    void validateLoginDatas_EmailAddressFoundedInDatabasePasswordIsBad_OneErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String exampleGoodEmail = "arnold@freemail.hu";
        when(queryHandlerMock.getCustomerByEmail(exampleGoodEmail)).thenReturn(exampleCustomer);
        List<String> errorMessages = (ArrayList) customerDataValidator
                .validateLoginDatas(exampleBadLoginDatasWrongPassword).get("errors");
        assertEquals(1, errorMessages.size());
        assertEquals(errorMessages.get(0), "Invalid email or password.");
    }

    @Test
    void validateLoginDatas_EmailAddressNotFoundedInDatabase_OneErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String exampleBadEmail = "stallone@freemail.hu";
        when(queryHandlerMock.getCustomerByEmail(exampleBadEmail)).thenReturn(null);
        List<String> errorMessages = (ArrayList) customerDataValidator
                .validateLoginDatas(exampleBadLoginDatasWrongPassword).get("errors");
        assertEquals(1, errorMessages.size());
        assertEquals(errorMessages.get(0), "Invalid email or password.");
    }

}