package com.example.demo.backened.controller;

import com.example.demo.backened.model.Book;
import com.example.demo.backened.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// this is the BookController class that handles HTTP requests related to books
// It uses the BookService to interact with the data layer and return JSON responses no views are returned
// This is a REST controller, so it returns JSON responses instead of views
@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins = "http://localhost:3000") // allow React calls
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public Book saveBook(@RequestBody Book book) {
        return service.saveBook(book);
    }
}
