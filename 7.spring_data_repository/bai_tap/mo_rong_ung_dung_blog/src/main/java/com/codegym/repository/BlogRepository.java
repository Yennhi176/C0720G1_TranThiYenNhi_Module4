package com.codegym.repository;


import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog,String> {
    Page<Blog> findAllByOrderByDateOfWriting(Pageable pageable);
    Page<Blog> findByTitleContaining(String keyword,Pageable pageable);
}
