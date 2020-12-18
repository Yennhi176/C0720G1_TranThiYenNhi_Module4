package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "division")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long divisionId;
    private String divisionName;
    @OneToMany(mappedBy = "division",cascade = CascadeType.ALL)
    List<Employee> listEmployee;
}
