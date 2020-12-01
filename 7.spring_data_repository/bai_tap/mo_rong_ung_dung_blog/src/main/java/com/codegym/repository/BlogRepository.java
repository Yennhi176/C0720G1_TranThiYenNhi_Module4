package com.codegym.repository;


import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BlogRepository extends JpaRepository<Blog,String> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByTitleContaining(String keyword,Pageable pageable);
    @Query(value = "select * from  blog order by dateOfWriting",nativeQuery = true)
    List<Blog> findAllByDateOfWritingAndOrderByDateOfWriting(String date);
}
