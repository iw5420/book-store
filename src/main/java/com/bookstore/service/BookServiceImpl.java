package com.bookstore.service;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.exception.DuplicateException;
import com.bookstore.exception.NotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookDao.findById(id).get();
    }

    @Override
    public Book insert(Book book) {
        if(bookDao.findByTitle(book.getTitle()).size()>0)
            throw new DuplicateException(book.getTitle());
        book.setPublish_date(LocalDateTime.now());
        Book savedBook = bookDao.save(book);
        return savedBook;
    }

    @Override
    public Book update(Book book) {
        if(bookDao.findByTitle(book.getTitle()).size()==0)
            throw new NotExistException(book.getTitle());
        Book pastBook = bookDao.findByTitle(book.getTitle()).get(0);
        pastBook.setAuthor(book.getAuthor());
        pastBook.setDescription(book.getDescription());
        pastBook.setPublish_date(LocalDateTime.now());
        Book savedBook = bookDao.save(pastBook);
        return savedBook;
    }

    @Override
    public void delete(Long id) {
        bookDao.deleteById(id);
    }
}
