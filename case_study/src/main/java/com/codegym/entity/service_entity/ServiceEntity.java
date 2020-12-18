package com.codegym.entity.service_entity;

import com.codegym.entity.contract.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

@Entity(name = "service")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    @NotEmpty(message = "Please enter a service name")
    private String serviceName;
    @Min(value = 1, message = "Please enter the area")
    private int serviceArea;
    @Min(value = 1, message = "Please enter service cost")
    private double serviceCost;
    @Min(value = 1, message = "Please enter the maximum number of people")
    private int serviceMaxPeople;
    @NotEmpty(message = "Please enter room standards")
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 1, message = "Please enter the pool area")
    private double poolArea;
    @Min(value = 1, message = "Please enter the floor number")
    private int numberOfFloors;
    @ManyToOne
    @JoinColumn(name = "rent_type_id", referencedColumnName = "rentTypeId")
    private RentType rentType;
    @ManyToOne
    @JoinColumn(name = "service_type_id", referencedColumnName = "serviceTypeId")
    private ServiceType serviceType;
    @OneToMany(mappedBy = "serviceEntity", cascade = CascadeType.ALL)
    List<Contract> listContract;

    @Override
    public String toString() {
        return serviceName + serviceArea + serviceCost + serviceMaxPeople + standardRoom + descriptionOtherConvenience + poolArea + numberOfFloors;
    }
    public String getCode(){
        NumberFormat numberFormat = new DecimalFormat("0000");
        return "DV-" + numberFormat.format(this.serviceId);
    }
}
