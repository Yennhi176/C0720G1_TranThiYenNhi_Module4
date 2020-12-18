package com.codegym.service.employee.impl;

import com.codegym.entity.employee.Employee;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllBy(Pageable pageable) {
        return employeeRepository.findAllBy(pageable);
    }

    @Override
    public Page<Employee> searchByName(String keyword, Pageable pageable) {
        return employeeRepository.findByEmployeeNameContaining(keyword, pageable);
    }
}
