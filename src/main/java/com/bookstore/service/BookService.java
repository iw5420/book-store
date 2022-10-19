package com.bookstore.service;

import com.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book insert(Book book);
    Book update(Book book);
    void delete(Long id);

}
