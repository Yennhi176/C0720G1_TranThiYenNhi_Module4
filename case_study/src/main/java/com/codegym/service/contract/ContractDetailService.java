package com.codegym.service.contract;

import com.codegym.entity.contract.ContractDetail;

import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> findAll();
    void save(ContractDetail contractDetail);
}
