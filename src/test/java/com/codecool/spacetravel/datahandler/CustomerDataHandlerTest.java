package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Customer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class CustomerDataHandlerTest {


    @Test
    void saveCustomerDatas() {

    }

    @Test
    void getExistingCustomerByEmail() {
        Customer exampleCustomer = new Customer("Bertalan", "Farkas", "berci@freemail.hu", "Hungary",
                "Budapest", "1140", "Hősök tere 1.", "abcd1234");
        CustomerDataHandler customerDataHandlerMock = Mockito.mock(CustomerDataHandler.class);
        EntityManager entityManagerMock = Mockito.mock(EntityManager.class);
        // Query query = Mockito.mock(Query.class);

        CustomerDataHandler customerDataHandler = new CustomerDataHandler(entityManagerMock);

        // when(customerDataHandlerMock.getBla(anyString())).thenReturn(exampleCustomer);

        assertEquals(customerDataHandler.getCustomerByEmail("berci@freemail.hu"), exampleCustomer);
    }

    @Test
    void getNullCustomerByEmail() {
        Customer exampleCustomer = null;
        String exampleEmail = "nonexisting@mail.com";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        CustomerDataHandler customerDataHandler = new CustomerDataHandler(entityManager);

        when(entityManager.createNamedQuery("Customer.getCustomerByEmail", Customer.class)
                .setParameter("email", exampleEmail)
                .getSingleResult())
                .thenReturn(exampleCustomer);

        // assertEquals(customerDataHandler.getCustomerByEmail(exampleEmail), null);
        assertNull(customerDataHandler.getCustomerByEmail(exampleEmail));
    }

}