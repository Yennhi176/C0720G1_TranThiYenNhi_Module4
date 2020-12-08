package com.codegym.service.impl;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(String id) {
        return blogRepository.findById(id).orElse(null);
    }


    @Override
    public void save( Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public void remove(Blog blog) {
        this.blogRepository.delete(blog);
    }

    @Override
    public void deleteById(String id) {
        this.blogRepository.deleteById(id);
    }
}
