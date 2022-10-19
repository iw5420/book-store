package com.bookstore.controller;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@Log4j2
@RestController
@RequestMapping( value = "/book")
public class BookController extends BaseController{

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<String> findAll() {
        log.info( "findAll" );
        return ResponseEntity.ok( response( bookService.findAll() ) );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<String> findById( @PathVariable Long id ) {
        log.info( "findById : {}", id );
        return ResponseEntity.ok( response( bookService.findById( id ) ) );
    }

    @PostMapping
    public ResponseEntity<String> insert( @Valid @RequestBody Book book ) {
        log.info( "insert : {}", book );
        Book savedBook = bookService.insert( book );
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}" ).buildAndExpand( book.getId()).toUri();
        return ResponseEntity.created( location ).body( response( savedBook ) );
    }

    @PutMapping
    public ResponseEntity<String> update( @Valid @RequestBody Book book ) {
        log.info( "update : {}", book );
        return ResponseEntity.ok( response( bookService.update( book ) ) );
    }

    @DeleteMapping( "/{id}" )
    public ResponseEntity<String> delete( @PathVariable( "id" ) Long id ) {
        log.info( "delete : {}", id );
        bookService.delete( id );
        return ResponseEntity.noContent().build();
    }
}
