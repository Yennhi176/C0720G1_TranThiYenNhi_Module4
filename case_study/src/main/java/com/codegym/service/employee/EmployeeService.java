package com.codegym.service.employee;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    void save(Employee employee);

    void delete(Employee employee);

    void update(Employee employee);

    Page<Employee> findAllBy(Pageable pageable);

    Page<Employee> searchByName(String keyword,Pageable pageable);
}
