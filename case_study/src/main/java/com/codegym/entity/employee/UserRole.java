package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "user_role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "userId")
    private AppUser user;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "roleId")
    private AppRole role;
}
