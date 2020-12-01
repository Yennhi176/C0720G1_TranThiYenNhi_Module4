package com.codegym.entity;

import javax.persistence.*;

@Entity(name = "blog")
//@Data //khởi tạo getter/setter
//@NoArgsConstructor //constructor k thâm số
//@AllArgsConstructor // constructor có tham số
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
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(String id, String title, String content, String author, String dateOfWriting) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.dateOfWriting = dateOfWriting;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateOfWriting() {
        return dateOfWriting;
    }

    public void setDateOfWriting(String dateOfWriting) {
        this.dateOfWriting = dateOfWriting;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
