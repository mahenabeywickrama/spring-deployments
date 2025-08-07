package com.example.springdeployments.service;

import com.example.springdeployments.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    Customer save(Customer customer);
    Customer update(Customer customer);
    void delete(int id);
}
