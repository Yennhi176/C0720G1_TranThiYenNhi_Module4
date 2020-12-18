package com.codegym.service.service_entity;

import com.codegym.entity.service_entity.ServiceEntity;

import java.util.List;

public interface ServiceEntityService {
    List<ServiceEntity> findAll();
    void save(ServiceEntity serviceEntity);
}
