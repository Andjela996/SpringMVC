package com.example.demo2.services;

import com.example.demo2.domain.Customer;

import java.util.List;


public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustById(Integer id);
    Customer saveOrUpdateCust(Customer c);
    void deleteCust(Integer id);
}
