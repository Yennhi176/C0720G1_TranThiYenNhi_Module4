package com.codegym.service.employee.impl;

import com.codegym.entity.employee.AppUser;
import com.codegym.repository.employee.AppUserRepository;
import com.codegym.service.employee.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AppUserRepository userRepository;
    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }
}
