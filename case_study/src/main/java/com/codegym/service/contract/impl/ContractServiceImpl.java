package com.codegym.service.contract.impl;

import com.codegym.entity.contract.Contract;
import com.codegym.repository.contract.ContractRepository;
import com.codegym.service.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }
}
