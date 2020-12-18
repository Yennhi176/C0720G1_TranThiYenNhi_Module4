package com.codegym.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncrytedPasswordUtils {
    // Encryte Password with BCryptPasswordEncoder
    public static String encrytePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
    //mã hõa password
    public static void main(String[] args) {
        String password = "abc";
        String encrytedPassword = encrytePassword(password);
        System.out.println("Encryted Password: " + encrytedPassword);
    }

}
