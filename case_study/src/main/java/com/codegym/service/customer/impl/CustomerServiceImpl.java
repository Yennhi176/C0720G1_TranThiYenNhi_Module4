package com.codegym.service.customer.impl;

import com.codegym.entity.customer.Customer;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findAllBy(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findByCustomerNameContainingOrCustomerAddressContaining(String keywordAfterCheck1,String keywordAfterCheck2, Pageable pageable) {
        return customerRepository.findByCustomerNameContainingOrCustomerAddressContaining(keywordAfterCheck1,keywordAfterCheck2,pageable);
    }
}
