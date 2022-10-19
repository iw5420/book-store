package com.bookstore.dao;

import com.bookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BookDao extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findByTitle(String title);
}
