package com.codegym.entity.service_entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "rent_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;
    private String rentTypeName;
    private double rentTypeCost;
    @OneToMany(mappedBy = "rentType",cascade = CascadeType.ALL)
    List<ServiceEntity> listServiceEntity;
}
