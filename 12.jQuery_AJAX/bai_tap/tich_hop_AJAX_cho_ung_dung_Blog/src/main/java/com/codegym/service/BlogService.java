package com.codegym.service;

import com.codegym.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void remove(Blog blog);

    void deleteById(String id);
}
