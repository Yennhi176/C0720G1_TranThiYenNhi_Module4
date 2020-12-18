package com.codegym.repository.service_entity;

import com.codegym.entity.service_entity.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceEntityRepository extends JpaRepository<ServiceEntity,Long> {
}
