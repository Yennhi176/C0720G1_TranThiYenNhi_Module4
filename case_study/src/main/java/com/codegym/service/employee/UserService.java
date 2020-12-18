package com.codegym.service.employee;

import com.codegym.entity.employee.AppUser;

import java.util.List;

public interface UserService {
    List<AppUser> findAll();
}
