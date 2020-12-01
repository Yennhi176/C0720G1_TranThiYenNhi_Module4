package com.codegym.service.impl;

import com.codegym.entity.Province;
import com.codegym.repository.ProvinceRepository;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Page<Province> findAll(Pageable pageable) {
        return this.provinceRepository.findAll(pageable);
    }

    @Override
    public Province findById(Long id) {
        return this.provinceRepository.findById(id).get();
    }

    @Override
    public void save(Province province) {
      this.provinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
     this.provinceRepository.deleteById(id);
    }


//    @Override
//    public Page<Province> findAll(Pageable pageable) {
//        return provinceRepository.findAll(pageable);
//    }
//
//    @Override
//    public Province findById(Long id) {
//        return provinceRepository.findById(id).get();
//    }
//
//    @Override
//    public void save(Province province) {
//        provinceRepository.save(province);
//    }
//
//    @Override
//    public void remove(Long id) {
//        provinceRepository.deleteById(id);
//    }
}
