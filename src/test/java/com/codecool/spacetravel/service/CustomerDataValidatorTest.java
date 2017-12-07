package com.codecool.spacetravel.service;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.model.Customer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerDataValidatorTest {

    private static Customer exampleCustomerWithCorrectDatas = createGoodCustomerDatas();
    private static Customer exampleCustomerWithFourWrongDatas = createBadCustomerDatasFourWrongData();
    private String goodConfirm = "terminator";
    private String badConfirm = "no_muscles";
    private static Map<String, String> exampleGoodLoginDatas = createGoodLoginDatas();
    private static Map<String, String> exampleBadLoginDatasWrongPassword = createBadLoginDatasWrongPassword();

    private static Customer createGoodCustomerDatas() {
        Customer exampleCorrectCustomer = new Customer();
        exampleCorrectCustomer.setFirstName("Arnold");
        exampleCorrectCustomer.setLastName("Schwarzenegger");
        exampleCorrectCustomer.setEmail("arnold@freemail.hu");
        exampleCorrectCustomer.setCountry("United States");
        exampleCorrectCustomer.setCity("Los Angeles");
        exampleCorrectCustomer.setPostalCode("90001");
        exampleCorrectCustomer.setAddress("Workout avenue 1.");
        exampleCorrectCustomer.setPassword("terminator");
        return exampleCorrectCustomer;
    }

    private static Customer createBadCustomerDatasFourWrongData() {
        Customer exampleCustomerWithWrongDatas = new Customer();
        exampleCustomerWithWrongDatas.setFirstName(""); // missing first name
        exampleCustomerWithWrongDatas.setLastName("Schwarz;enegger"); // sign in human last name
        exampleCustomerWithWrongDatas.setEmail("missingdothu@freemail"); // missing .hu, .com etc. element
        exampleCustomerWithWrongDatas.setCountry("Unit6 States"); // number in country name
        exampleCustomerWithWrongDatas.setCity("Los Angeles");
        exampleCustomerWithWrongDatas.setPostalCode("90001");
        exampleCustomerWithWrongDatas.setAddress("Workout avenue 1.");
        exampleCustomerWithWrongDatas.setPassword("terminator");
        return exampleCustomerWithWrongDatas;
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
        List<String> errorMessages = customerDataValidator.validateRegistrationDatas(exampleCustomerWithCorrectDatas, goodConfirm);
        assertEquals(errorMessages.size(), 0);
    }

    @Test
    void validateRegistrationDatas_BadConfirm_OneErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        List<String> errorMessages = customerDataValidator
                .validateRegistrationDatas(exampleCustomerWithCorrectDatas, badConfirm);
        assertEquals(errorMessages.size(), 1);
    }

    @Test
    void validateRegistrationDatas_BadDatas_FourErrorMessages() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String goodConfirm = "terminator";
        List<String> errorMessages = customerDataValidator
                .validateRegistrationDatas(exampleCustomerWithFourWrongDatas, goodConfirm);
        assertEquals(errorMessages.size(), 4);
    }

    @Test
    void validateLoginDatas_EmailAddressFoundedInDatabasePasswordIsGood_NoErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String exampleGoodEmail = "arnold@freemail.hu";
        when(queryHandlerMock.getCustomerByEmail(exampleGoodEmail)).thenReturn(exampleCustomerWithCorrectDatas);
        List<String> errorMessages = (ArrayList) customerDataValidator
                .validateLoginDatas(exampleGoodLoginDatas).get("errors");
        assertEquals(0, errorMessages.size());
    }


    @Test
    void validateLoginDatas_EmailAddressFoundedInDatabasePasswordIsBad_OneErrorMessage() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidator = new CustomerDataValidator(queryHandlerMock);
        String exampleGoodEmail = "arnold@freemail.hu";
        when(queryHandlerMock.getCustomerByEmail(exampleGoodEmail)).thenReturn(exampleCustomerWithCorrectDatas);
        List<String> errorMessages = (ArrayList) customerDataValidator
                .validateLoginDatas(exampleBadLoginDatasWrongPassword).get("errors");
        assertEquals(1, errorMessages.size());
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
    }

}
