package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;

import java.util.List;

public interface ContractService {
    List<Contract> findAll();
    void save(Contract contract);
}
