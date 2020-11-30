package com.codegym.tao_ung_dung_blog.service;

import com.codegym.tao_ung_dung_blog.entity.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    Blog findById(String id);

    void save(Blog blog);

    void remove(Blog blog);
}
