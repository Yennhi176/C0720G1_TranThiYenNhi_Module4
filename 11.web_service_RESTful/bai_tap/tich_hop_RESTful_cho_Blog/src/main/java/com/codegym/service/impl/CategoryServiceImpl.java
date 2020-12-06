package com.codegym.service.impl;

import com.codegym.repository.BlogRepository;
import com.codegym.repository.CategoryRepository;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<BlogRepository.Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public BlogRepository.Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BlogRepository.Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void remove(BlogRepository.Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Page<BlogRepository.Category> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
