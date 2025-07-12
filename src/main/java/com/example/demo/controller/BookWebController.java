package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// This is a Spring MVC controller that handles web requests related to books
// It uses the BookService to interact with the data layer and return views{html}
@Controller
public class BookWebController {

    private final BookService service; // This is the just a variable to hold the BookService instance that will be injected by Spring via constructor injection

    public BookWebController(BookService service) { // normally BookWebController controller = new BookWebController(new BookService());
        // This is a Spring-managed bean, so we use constructor injection to get the BookService instance
        // This allows us to use the service methods in our web controller
        this.service = service;  // Constructor injection for BookService  
    }

    //line 12 ka variable service mein constructor se inject hota hai, jo BookService ka instance hai
    // service variable is used to call methods from BookService to interact with the data layer

    @GetMapping("/books/view")
    public String viewBooks(Model model) { 
        model.addAttribute("books", service.getAllBooks()); // Fetches all books from the service and adds them to the model
        return "books"; // maps to books.html
    }

    @GetMapping("/books/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book"; // maps to add-book.html
    }

    @PostMapping("/books/save")
    public String saveBook(Book book) {
        service.saveBook(book);
        return "redirect:/books/view";
    }
}
