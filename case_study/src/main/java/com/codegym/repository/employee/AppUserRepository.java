package com.codegym.repository.employee;

import com.codegym.entity.employee.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String userName);
}
