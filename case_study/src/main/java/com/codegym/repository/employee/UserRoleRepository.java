package com.codegym.repository.employee;

import com.codegym.entity.employee.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<AppRole,Long> {
    @Query(value = "select `role_name` from `role` join `user_role` on `role`.`role_id` = `user_role`.`role_id` join user on `user_role`.`user_id` = `user`.`user_id` where `user`.`user_id` = ?1", nativeQuery = true)
    List<String> findByUser(Long id);
}
