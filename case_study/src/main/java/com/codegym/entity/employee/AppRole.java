package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;
    private String roleName;
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "user_role",
//            joinColumns = @JoinColumn(name = "role_id"),
//            inverseJoinColumns = @JoinColumn(name = "username"))
//    @JsonManagedReference
//    private List<User> listUser;
//   @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
//    List<UserRole> listUserRole;

}
