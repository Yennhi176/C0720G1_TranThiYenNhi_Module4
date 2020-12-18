package com.codegym.service.service_entity.impl;

import com.codegym.entity.service_entity.RentType;
import com.codegym.repository.service_entity.RentTypeRepository;
import com.codegym.service.service_entity.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {
    @Autowired
    private RentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
