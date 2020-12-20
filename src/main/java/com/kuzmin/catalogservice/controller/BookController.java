package com.kuzmin.catalogservice.controller;

import com.kuzmin.catalogservice.model.Book;
import com.kuzmin.catalogservice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public Collection<Book> get() {
        return bookService.viewBookList();
    }
    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn).orElse(null);
    }
    @PostMapping
    public Book post(@RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }
    @DeleteMapping("{isbn}")
    public Book delete(@PathVariable String isbn) {
        return bookService.removeBookFromCatalog(isbn);
    }
    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn, @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }
}
