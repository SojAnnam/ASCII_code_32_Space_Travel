package com.codecool.spacetravel.datahandler;

import com.codecool.spacetravel.model.Customer;
import com.codecool.spacetravel.model.RoomReservation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomerDataHandler {

    private EntityManager em;

    public CustomerDataHandler(EntityManager em) {
        this.em = em;
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

    public Customer getBla(String email){
        Customer customer= em.createNamedQuery("Customer.getCustomerByEmail", Customer.class)
                .setParameter("email", email).getSingleResult();
        return customer;
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = null;
        try{ customer = getBla(email);

        } catch (Exception e){
            System.out.println("No record found: " + e.getMessage());
        }
        return customer;
    }

}
