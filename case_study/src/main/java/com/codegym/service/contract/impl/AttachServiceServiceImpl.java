package com.codegym.service.contract.impl;

import com.codegym.entity.contract.AttachService;
import com.codegym.repository.contract.AttachServiceRepository;
import com.codegym.service.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;
    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }
}
