package com.bookstore;

import com.bookstore.dao.BookDao;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Log4j2
@SpringBootTest
class BookStoreApplicationTests {

    @Autowired
    BookDao bookDao;

    @Autowired
    BookService bookService;

    // 1. 測試呼叫查詢book對應表資料 API，並顯示其內容。
    @Test
    void testFindAll(){
        log.info( "start test1---findAll" );
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            log.info(book.getId()+"-"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getDescription()+"-"+book.getPublish_date());
        }
        log.info( "end test1---findAll" );
    }

    // 2. 測試呼叫新增book對應表資料 API。
    @Test
    void testInsert(){
        log.info( "start test2---insert book" );
        Book newBook = new Book();
        newBook.setTitle("OCP：Java SE 11 Developer認證指南（下）API剖析運用篇");
        newBook.setAuthor("曾瑞君");
        newBook.setDescription("下冊聚焦Java API應用，包含泛型、集合物件與Map族群、基礎IO與NIO.2、執行緒與並行架構");
        newBook.setPublish_date(LocalDateTime.now());
        bookService.insert(newBook);
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            log.info(book.getId()+"-"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getDescription()+"-"+book.getPublish_date());
        }
        log.info( "end test2---insert book" );
    }

    //3. 測試呼叫更新Book對應表資料 API，並顯示其內容。
    @Test
    void testUpdate(){
        log.info( "start test3---update book" );
        Book newBook = new Book();
        newBook.setTitle("OCP：Java SE 11 Developer 認證指南（上）物件導向設計篇");
        newBook.setAuthor("修改此部分");
        newBook.setDescription("下冊聚焦Java API應用，包含泛型、集合物件與Map族群、基礎IO與NIO.2、執行緒與並行架構");
        newBook.setPublish_date(LocalDateTime.now());
        bookService.update(newBook);
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            log.info(book.getId()+"-"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getDescription()+"-"+book.getPublish_date());
        }
        log.info( "end test3---update book" );
    }

    //4. 測試呼叫刪除book對應表資料 API。
    @Test
    void testDelete(){
        log.info( "start test4---delete book" );
        log.info( "before" );
        List<Book> bookList = bookService.findAll();
        for (Book book : bookList) {
            log.info(book.getId()+"-"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getDescription()+"-"+book.getPublish_date());
        }
        bookService.delete(1L);
        log.info( "after" );
        bookList = bookService.findAll();
        for (Book book : bookList) {
            log.info(book.getId()+"-"+book.getTitle()+"-"+book.getAuthor()+"-"+book.getDescription()+"-"+book.getPublish_date());
        }
        log.info( "end test4---delete currency" );
    }

}
