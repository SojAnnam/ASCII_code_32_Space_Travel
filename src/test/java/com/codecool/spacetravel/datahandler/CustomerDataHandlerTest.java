package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.DAO.QueryHandler;
import com.codecool.spacetravel.controller.collectdata.CustomerDataHandler;
import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.service.CustomerDataValidator;
import org.hibernate.persister.spi.UnknownPersisterException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerDataHandlerTest {

    private static Map<String, String> exampleCorrectCustomerDatas = createGoodCustomerDatas();
    private static Customer exampleCustomer = new Customer("Arnold", "Schwarzenegger",
            "arnold@freemail.hu", "United States", "Los Angeles",
            "90001", "Workout avenue 1.", "terminator");

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

    @Test
    void saveCustomerDatas_PersistingFailed_SavingSucceededIsFalse() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidatorMock = Mockito.mock(CustomerDataValidator.class);
        CustomerDataHandler customerDataHandler = new CustomerDataHandler(queryHandlerMock, customerDataValidatorMock);
        Exception exampleException = new UnknownPersisterException("Database problem. Try it later.");
        doThrow(exampleException).when(queryHandlerMock).saveNewCustomer(any());
        boolean savingSucceeded = customerDataHandler.saveCustomerDatas(exampleCorrectCustomerDatas);
        assertEquals(false, savingSucceeded);
    }

    @Test
    void saveCustomerDatas_PersistingSucceeded_SavingSucceededIsTrue() {
        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidatorMock = Mockito.mock(CustomerDataValidator.class);
        CustomerDataHandler customerDataHandler = new CustomerDataHandler(queryHandlerMock, customerDataValidatorMock);
        doNothing().when(queryHandlerMock).saveNewCustomer(exampleCustomer);
        boolean savingSucceeded = customerDataHandler.saveCustomerDatas(exampleCorrectCustomerDatas);
        assertEquals(true, savingSucceeded);
    }

    @Test
    void collectCustomerRegistrationData_RegistrationSucceeded_NoErrorMessageSavingBooleansAreTrue() throws IllegalAccessException, InstantiationException {
        List<String> exampleEmptyErrorMessages = new ArrayList<>();

        Map<String,String> allRequestParams = new LinkedHashMap<>();
        allRequestParams.put("firstname", "Arnold");
        allRequestParams.put("lastname", "Schwarzenegger");
        allRequestParams.put("email", "arnold@freemail.hu");
        allRequestParams.put("country", "United States");
        allRequestParams.put("city", "Los Angeles");
        allRequestParams.put("postalcode", "90001");
        allRequestParams.put("password", "terminator");
        allRequestParams.put("confirm", "terminator");

        // Model model = Mockito.mock(Model.class);
        Model model = new Model() {
            @Override
            public Model addAttribute(String s, Object o) {
                return null;
            }

            @Override
            public Model addAttribute(Object o) {
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> collection) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> map) {
                return null;
            }

            @Override
            public boolean containsAttribute(String s) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };

        /*Request requestMock = Mockito.mock(Request.class);
        when(requestMock.queryParams("firstname")).thenReturn("Arnold");
        when(requestMock.queryParams("lastname")).thenReturn("Schwarzenegger");
        when(requestMock.queryParams("email")).thenReturn("arnold@freemail.hu");
        when(requestMock.queryParams("country")).thenReturn("United States");
        when(requestMock.queryParams("city")).thenReturn("Los Angeles");
        when(requestMock.queryParams("postalcode")).thenReturn("90001");
        when(requestMock.queryParams("password")).thenReturn("terminator");
        when(requestMock.queryParams("confirm")).thenReturn("terminator");*/

        // doReturn(exampleRequestQueryParams).when(requestMock).queryParams();

        QueryHandler queryHandlerMock = Mockito.mock(QueryHandler.class);
        CustomerDataValidator customerDataValidatorMock = Mockito.mock(CustomerDataValidator.class);
        CustomerDataHandler customerDataHandler = new CustomerDataHandler(queryHandlerMock, customerDataValidatorMock);

        when(customerDataValidatorMock.validateRegistrationDatas(exampleCorrectCustomerDatas)).thenReturn(exampleEmptyErrorMessages);
        doNothing().when(queryHandlerMock).saveNewCustomer(exampleCustomer);

        Model resultModel = customerDataHandler.collectCustomerRegistrationData(allRequestParams, model);
        System.out.println("RESULTMODEL: " + resultModel.asMap().size());

        List<String> errorMessages = (List<String>) resultModel.asMap().get("errors");

        assertEquals(true, resultModel.asMap().get("savingsucceeded"));
        assertEquals(true, resultModel.asMap().get("savingtried"));
        assertEquals(0, errorMessages.size());
    }

}
