package com.codegym.service;

import com.codegym.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    void save(Book book);
    Book findById(Integer id);
    String borrowBooks(Integer id) throws Exception;
    String giveBookBack(Integer id,Integer bookNumber);
}
