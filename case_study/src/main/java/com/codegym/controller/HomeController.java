package com.codegym.controller;

import com.codegym.entity.employee.AppUser;
import com.codegym.repository.employee.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    AppUserRepository appUserRepository;


    @GetMapping({"/","/home"})
    public String goHome(){

//        AppUser appUser = new AppUser();
//
//        appUser.setUsername("userabc");
//        appUser.setPassword(new BCryptPasswordEncoder().encode("123"));
//
//        appUserRepository.save(appUser);

        return "home";
    }
}
