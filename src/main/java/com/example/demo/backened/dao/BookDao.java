// dao/BookDao.java
package com.example.demo.backened.dao;

import com.example.demo.backened.model.Book;
import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book save(Book book);
    void delete(Long id);
    Book findById(Long id);
}

