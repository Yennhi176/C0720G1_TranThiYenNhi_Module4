package com.codegym.service;

import com.codegym.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProvinceService {
    Page<Province> findAll(Pageable pageable);

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
