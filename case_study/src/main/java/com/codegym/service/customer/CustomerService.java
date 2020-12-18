package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(Long id);

    void save(Customer customer);

    void delete(Customer customer);

    void update(Customer customer);

    Page<Customer> findAllBy(Pageable pageable);

    Page<Customer> findByCustomerNameContainingOrCustomerAddressContaining(String keywordAfterCheck1, String keywordAfterCheck2,Pageable pageable);
}
