package com.codegym.entity;

import javax.persistence.*;
import java.util.List;

@Entity(name = "category")
public class Category {
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
