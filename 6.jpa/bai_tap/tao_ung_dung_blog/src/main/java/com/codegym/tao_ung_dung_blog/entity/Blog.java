package com.codegym.tao_ung_dung_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "blog")
@Data //khởi tạo getter/setter
@NoArgsConstructor //constructor k thâm số
@AllArgsConstructor // constructor có tham số
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",columnDefinition = "INTEGER")
    private String id;
    private String title;
    private String content;
    private String author;
    @Column(name = "date",columnDefinition = "DATE")
    private String dateOfWriting;
}
