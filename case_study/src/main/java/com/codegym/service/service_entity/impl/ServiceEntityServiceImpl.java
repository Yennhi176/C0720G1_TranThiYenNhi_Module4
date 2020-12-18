package com.codegym.service.service_entity.impl;

import com.codegym.entity.service_entity.ServiceEntity;
import com.codegym.repository.service_entity.ServiceEntityRepository;
import com.codegym.service.service_entity.ServiceEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceEntityServiceImpl implements ServiceEntityService {
    @Autowired
    private ServiceEntityRepository serviceEntityRepository;

    @Override
    public List<ServiceEntity> findAll() {
        return serviceEntityRepository.findAll();
    }

    @Override
    public void save(ServiceEntity serviceEntity) {
        serviceEntityRepository.save(serviceEntity);
    }
}
