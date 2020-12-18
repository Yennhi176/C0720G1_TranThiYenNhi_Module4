package com.codegym.entity.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "education_degree")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationDegreeId;
    private String educationDegreeName;
    @OneToMany(mappedBy = "educationDegree",cascade = CascadeType.ALL)
    List<Employee> listEmployee;
}
