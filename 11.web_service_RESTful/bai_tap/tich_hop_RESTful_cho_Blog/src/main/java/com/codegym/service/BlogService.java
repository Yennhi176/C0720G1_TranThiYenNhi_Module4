package com.codegym.service;

import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void remove(Blog blog);

    Page<Blog> searchByTitle(String keyword, Pageable pageable);


    Page<Blog> findAllByOrderByDateOfWriting(Pageable pageable);
}
