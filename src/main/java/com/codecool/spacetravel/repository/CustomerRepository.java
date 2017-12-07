package com.codecool.spacetravel.repository;

import com.codecool.spacetravel.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> getAllCustomers();

    Customer getCustomerByEmail(@Param("email") String email);

    Customer getCustomerById(@Param("id") Long id);
}
