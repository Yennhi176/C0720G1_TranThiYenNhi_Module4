package com.codegym.entity.service_entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "service_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceTypeId;
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType",cascade = CascadeType.ALL)
    List<ServiceEntity> listServiceEntity;
}
