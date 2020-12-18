package com.codegym.entity.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "customer_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerTypeId;
    private String customerTypeName;
    @OneToMany(mappedBy = "customerType",cascade = CascadeType.ALL)
    private List<Customer> listCustomer;
}
