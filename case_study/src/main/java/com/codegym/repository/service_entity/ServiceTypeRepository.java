package com.codegym.repository.service_entity;

import com.codegym.entity.service_entity.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType,Long> {
}
