package com.codegym.entity.employee;

import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotEmpty(message = "Please enter name")
    private String employeeName;

    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @NotBlank(message = "Please enter your date of birth")
    private String employeeBirthday;

    @Pattern(regexp = "\\d{9}", message = "Please enter the ID card to be in the correct format XXXXXXXXX")
    private String employeeIdCard;

    @Min(value = 1,message = "Please enter your salary")
    private double employeeSalary;

    @Pattern(regexp = "(^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$)", message = "Please enter the correct format phone number 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx")
    private String employeePhone;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$", message = "Please enter email address to email format abc@gmail.com")
    private String employeeEmail;

    @NotEmpty(message = "Please enter your address")
    private String employeeAddress;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "positionId")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "educationDegreeId")
    private EducationDegree educationDegree;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "divisionId")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private AppUser user;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    List<Contract> listContract;


}
