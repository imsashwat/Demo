package com.example.demo.backened.repository;

import com.example.demo.backened.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}

