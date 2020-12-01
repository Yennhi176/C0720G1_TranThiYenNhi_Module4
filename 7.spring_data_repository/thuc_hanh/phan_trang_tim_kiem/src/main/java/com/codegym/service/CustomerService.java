package com.codegym.service;

import com.codegym.entity.Customer;
import com.codegym.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Customer findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Page<Customer> findAllByProvince(Pageable pageable);

    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);
}
