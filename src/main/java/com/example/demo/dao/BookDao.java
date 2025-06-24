// dao/BookDao.java
package com.example.demo.dao;

import com.example.demo.model.Book;
import java.util.List;

public interface BookDao {
    List<Book> findAll();
    Book save(Book book);
    void delete(Long id);
}

