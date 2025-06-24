// service/BookService.java
package com.example.demo.service;

import com.example.demo.dao.BookDao;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao dao;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public Book saveBook(Book book) {
        return dao.save(book);
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }
}
