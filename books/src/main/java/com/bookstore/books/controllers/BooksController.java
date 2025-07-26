package com.bookstore.books.controllers;

import com.bookstore.books.dtos.BookDto;
import com.bookstore.books.services.BooksService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok(booksService.getAllBooks());
    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> save(@RequestBody BookDto book) {
        return ResponseEntity.ok().body(booksService.save(book));
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<BookDto> update(@PathVariable String isbn, @RequestBody BookDto book) {
        return ResponseEntity.ok().body(booksService.updateBook(isbn, book));
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<BookDto> getBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok().body(booksService.getBookByISBN(isbn));
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<BookDto> deleteBookByISBN(@PathVariable String isbn) {
        return ResponseEntity.ok().body(booksService.deleteBookByISBN(isbn));
    }
}
