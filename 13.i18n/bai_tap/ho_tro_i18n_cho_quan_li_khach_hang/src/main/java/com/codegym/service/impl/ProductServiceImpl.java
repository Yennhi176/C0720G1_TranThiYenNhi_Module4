package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.productRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Integer id, Product product) {
        this.productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        this.productRepository.delete(product);
    }

}
