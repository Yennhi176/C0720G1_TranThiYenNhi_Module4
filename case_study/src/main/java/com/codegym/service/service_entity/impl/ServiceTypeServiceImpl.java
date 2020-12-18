package com.codegym.service.service_entity.impl;

import com.codegym.entity.service_entity.ServiceType;
import com.codegym.repository.service_entity.ServiceTypeRepository;
import com.codegym.service.service_entity.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
