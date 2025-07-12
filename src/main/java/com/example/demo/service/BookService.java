// service/BookService.java
package com.example.demo.service;

import com.example.demo.dao.BookDao;
// import com.example.demo.kafka.BookProducer;
import com.example.demo.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDao dao;
    @Autowired
    // private BookProducer producer;

    public BookService(BookDao dao) {
        this.dao = dao;
    }

    public List<Book> getAllBooks() {
        return dao.findAll();
    }

    public Book saveBook(Book book) {
        Book savedBook = dao.save(book);
        // producer.sendBookCreatedMessage("New book added: " + savedBook.getTitle());
        return savedBook;
    }

    public void deleteBook(Long id) {
        dao.delete(id);
    }



}
