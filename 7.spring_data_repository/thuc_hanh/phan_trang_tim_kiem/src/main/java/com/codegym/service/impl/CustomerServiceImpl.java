package com.codegym.service.impl;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import com.codegym.repository.CustomerRepository;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
       this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByProvince(Pageable pageable) {
        return this.customerRepository.findAllByProvince(pageable);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable) {
        return this.customerRepository.findAllByFirstNameContaining(firstName ,pageable);
    }
}
