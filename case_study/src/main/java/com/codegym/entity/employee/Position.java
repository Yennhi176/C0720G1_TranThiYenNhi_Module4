package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "position")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long positionId;
    private String positionName;
    @OneToMany(mappedBy = "position",cascade = CascadeType.ALL)
    List<Employee> listEmployee;
}
