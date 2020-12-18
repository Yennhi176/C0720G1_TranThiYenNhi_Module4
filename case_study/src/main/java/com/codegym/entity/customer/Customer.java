package com.codegym.entity.customer;

import com.codegym.common.Adult;
import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    @NotEmpty(message = "Please enter name")
    private String customerName;

    @Column(name = "customer_birthday", columnDefinition = "DATE")
    @NotBlank(message = "Please enter your date of birth")
    @Adult(min = 18,max = 100,message = "Please enter age 18 to 100")
    private String customerBirthday;

    private Integer customerGender;

    @Pattern(regexp = "\\d{9}" ,message = "Please enter the ID card to be in the correct format XXXXXXXXX")
    private String customerIdCard;

    @Pattern(regexp = "(^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$)",message = "Please enter the correct format phone number 090xxxxxxx or 091xxxxxxx or (84) + 90xxxxxxx or (84) + 91xxxxxxx")
    private String customerPhone;

    @Pattern(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message = "Please enter email address to email format abc@gmail.com")
    private String customerEmail;

    @NotEmpty(message = "Please enter your address")
    private String customerAddress;
    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customerTypeId")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    List<Contract> listContract;

    @Override
    public String toString() {
        return customerName + customerBirthday + customerGender + customerIdCard + customerPhone + customerEmail + customerAddress;
    }
    public String getCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "KH-" + numberFormat.format(this.customerId);
    }
}
