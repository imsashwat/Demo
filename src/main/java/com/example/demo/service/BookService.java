package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book saveBook(Book book) {
        System.out.println("Saving: " + book.getTitle());
        return repo.save(book);
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }

    // etc.
}
