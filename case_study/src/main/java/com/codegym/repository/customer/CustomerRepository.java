package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAllBy(Pageable pageable);
    Page<Customer> findByCustomerNameContainingOrCustomerAddressContaining(String keywordAfterCheck1,String keywordAfterCheck2,Pageable pageable);
}
