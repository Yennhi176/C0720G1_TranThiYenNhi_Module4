package com.codegym.repository;


import com.codegym.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;
import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,String> {
    Page<Blog> findAllByOrderByDateOfWriting(Pageable pageable);
    Page<Blog> findByTitleContaining(String keyword, Pageable pageable);

    @Entity(name = "category")
    class Category {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id",columnDefinition = "INTEGER")
        private String id;
        private String nameCategory;
        @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
        private List<Blog> listBlog;

        public Category() {
        }

        public Category(String nameCategory) {
            this.nameCategory = nameCategory;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNameCategory() {
            return nameCategory;
        }

        public void setNameCategory(String nameCategory) {
            this.nameCategory = nameCategory;
        }

        public List<Blog> getListBlog() {
            return listBlog;
        }

        public void setListBlog(List<Blog> listBlog) {
            this.listBlog = listBlog;
        }
    }
}
