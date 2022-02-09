package com.example.demo2.services;


import com.example.demo2.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class CustomerServiceImpl implements CustomerService {
    private Map<Integer, Customer> customers;

    public CustomerServiceImpl(){
        customers = new HashMap<>();
        loadCustomers();
    }

    private void loadCustomers() {
        Customer c = new Customer();
        c.setId(1);
        c.setfName("Customer");
        c.setlName("1");
        c.setEmail("somemail@provider.com");

        Customer c2 = new Customer();
        c2.setId(2);
        c2.setfName("Customer");
        c2.setlName("2");
        c2.setEmail("somemail@provider.com");

        Customer c3 = new Customer();
        c3.setId(3);
        c3.setfName("Customer");
        c3.setlName("3");
        c3.setEmail("somemail@provider.com");

        Customer c4 = new Customer();
        c4.setId(4);
        c4.setfName("Customer");
        c4.setlName("4");
        c4.setEmail("somemail@provider.com");

        customers.put(c.getId(),c);
        customers.put(c2.getId(),c2);
        customers.put(c3.getId(),c3);
        customers.put(c4.getId(),c4);
    }


    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getCustById(Integer id) {
        return customers.get(id);
    }

    @Override
    public Customer saveOrUpdateCust(Customer c) {
        if(c==null){
            throw new RuntimeException("Customer is null!");
        }
        else{
            if(c.getId()==null){
                c.setId(Collections.max(customers.keySet())+1);
            }
            customers.put(c.getId(),c);
            return c;
        }
    }

    @Override
    public void deleteCust(Integer id) {
        customers.remove(id);
    }
}
