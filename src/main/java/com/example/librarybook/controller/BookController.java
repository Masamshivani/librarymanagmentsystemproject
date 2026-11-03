package com.example.librarybook.controller;

import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.librarybook.model.Book;
import com.example.librarybook.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Add Book
    @PostMapping
    public ResponseEntity<Book> addBook(
            @Valid @RequestBody Book book) {

        Book savedBook = bookService.addBook(book);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedBook);
    }

    // Get All Books
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(
                bookService.getAllBooks());
    }

    // Search Book By ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                bookService.getBookById(id));
    }

    // Update Availability
    @PutMapping("/{id}/availability")
    public ResponseEntity<Book> updateAvailability(
            @PathVariable Integer id,
            @RequestParam boolean available) {

        return ResponseEntity.ok(
                bookService.updateAvailability(id, available));
    }

    // Delete Book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                bookService.deleteBook(id));
    }
}