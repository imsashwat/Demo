// service/BookService.java
package com.example.demo.backened.service;

import com.example.demo.backened.dao.BookDao;
import com.example.demo.backened.exception.ResourceNotFoundException;
// import com.example.demo.kafka.BookProducer;
import com.example.demo.backened.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Service
public class BookService {
    private final BookDao dao;
    //@Autowire
    // private BookProducer producer;
   
    private final ExecutorService executorService;

    public BookService(BookDao dao, ExecutorService executorService) {
        this.dao = dao;
        this.executorService = executorService;
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
        Book existingBook = dao.findById(id);
        if (existingBook == null) {
            throw new ResourceNotFoundException("Book not found with ID: " + id);
        }
        dao.delete(id);
    }

    /**
     * This method processes a book asynchronously.
     * It simulates a time-consuming task by sleeping for 2 seconds.
     * The @Async annotation allows this method to run in a separate thread.that is different from the main thread
    
    @Async  // 👈 This makes it run in a new thread 
    public void processBook(Book book) {
        System.out.println("Processing in thread: " + Thread.currentThread().getName());
        // Simulate time-consuming task
        try {
            Thread.sleep(2000); // Simulating a delay of 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Save or process book
        System.out.println("Processed book: " + book.getTitle());
    }
        */

         

    

   
    // public void processBooks(List<Book> books) {
    //     for (Book book : books) {
    //         executorService.submit(() -> {
    //             System.out.println("Processing in thread: " + Thread.currentThread().getName());

    //             try {
    //                 Thread.sleep(2000); // simulate delay
    //             } catch (InterruptedException e) {
    //                 Thread.currentThread().interrupt();
    //             }

    //             System.out.println("Processed book: " + book.getTitle());
    //         });
    //     }
    // }



    @Async
    public CompletableFuture<String> processBook(Book book) {
        System.out.println("Processing book in thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Processed book: " + book.getTitle());
        return CompletableFuture.completedFuture("Processed: " + book.getTitle());
    }

    public CompletableFuture<Void> processAllBooks(List<Book> books) {
        List<CompletableFuture<String>> futures = books.stream()
            .map(this::processBook)
            .toList();

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
    }
    

}
