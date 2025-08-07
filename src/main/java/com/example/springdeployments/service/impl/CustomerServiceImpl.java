package com.example.springdeployments.service.impl;

import com.example.springdeployments.entity.Customer;
import com.example.springdeployments.repo.CustomerRepository;
import com.example.springdeployments.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException
                        ("Customer not found with id: " + id)
        );
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        Customer existingCustomer = findById(customer.getId());
        existingCustomer.setFirstname(customer.getFirstname());
        existingCustomer.setLastname(customer.getLastname());
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void delete(int id) {
        Customer customer = findById(id);
        customerRepository.delete(customer);
    }
}
