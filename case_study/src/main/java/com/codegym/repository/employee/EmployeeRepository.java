package com.codegym.repository.employee;

import com.codegym.entity.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findAllBy(Pageable pageable);
    Page<Employee> findByEmployeeNameContaining(String keyword, Pageable pageable);
}
