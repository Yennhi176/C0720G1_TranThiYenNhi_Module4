package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String username;
    private String password;
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    List<UserRole> listUserRole;
//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    List<Employee> listEmployee;

}
