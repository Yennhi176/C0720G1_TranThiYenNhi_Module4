package com.codegym.service.impl;

import com.codegym.entity.Blog;
import com.codegym.repository.BlogRepository;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
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
    public Page<Blog> searchByTitle(String keyword, Pageable pageable) {
        return blogRepository.findByTitleContaining(keyword,pageable);
    }

    @Override
    public Page<Blog> findAllByOrderByDateOfWriting(Pageable pageable) {
        return blogRepository.findAllByOrderByDateOfWriting(pageable);
    }


}
