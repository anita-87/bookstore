package com.bookstore.books.services.impl;

import com.bookstore.books.dtos.BookDto;
import com.bookstore.books.exceptions.ResourceNotFoundException;
import com.bookstore.books.models.Book;
import com.bookstore.books.repositories.BooksRepository;
import com.bookstore.books.services.BooksService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BooksService {

    private final BooksRepository booksRepository;
    private final ObjectMapper objectMapper;

    public BookServiceImpl(BooksRepository booksRepository, ObjectMapper objectMapper) {
        this.booksRepository = booksRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return booksRepository.getAllBooks()
                .stream()
                .map(book -> objectMapper.convertValue(book, BookDto.class))
                .toList();
    }

    @Override
    public BookDto getBookByISBN(String isbn) {
        Book book = booksRepository.getBookByISBN(isbn);
        return objectMapper.convertValue(book, BookDto.class);
    }

    @Override
    public BookDto save(BookDto book) {
        Book bookEntity = objectMapper.convertValue(book, Book.class);
        Book savedBook = booksRepository.save(bookEntity);
        return objectMapper.convertValue(savedBook, BookDto.class);
    }

    @Override
    public BookDto updateBook(String isbn, BookDto book) {
        Book bookEntity = booksRepository.getBookByISBN(isbn);
        if (bookEntity == null) {
            throw new ResourceNotFoundException(String.format("Book with ISBN %s not found", isbn));
        }
        Book bookToUpdate = objectMapper.convertValue(bookEntity, Book.class);
        Book savedBook = booksRepository.updateBook(bookToUpdate);
        return objectMapper.convertValue(savedBook, BookDto.class);
    }

    @Override
    public BookDto deleteBookByISBN(String isbn) {
        Book deletedBook = booksRepository.deleteBookByISBN(isbn);
        return objectMapper.convertValue(deletedBook, BookDto.class);
    }


}
