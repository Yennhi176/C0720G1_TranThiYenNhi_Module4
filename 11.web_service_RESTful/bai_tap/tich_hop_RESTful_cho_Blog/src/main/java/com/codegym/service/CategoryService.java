package com.codegym.service;

import com.codegym.repository.BlogRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    List<BlogRepository.Category> findAll();

    BlogRepository.Category findById(String id);

    void save(BlogRepository.Category category);

    void remove(BlogRepository.Category category);

    Page<BlogRepository.Category> findAll(Pageable pageable);
}
