package com.masudbappy.unillib.controllers;

import com.masudbappy.unillib.entities.Book;
import com.masudbappy.unillib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookConroller {

    public final BookService bookService;

    @Autowired
    public BookConroller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/all")
    public List<Book> findAll(){
        return bookService.findAll();
    }


    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBook(@RequestBody Book book) {
        book = this.bookService.saveBook(book);
        return ResponseEntity.ok(book);
    }
}
