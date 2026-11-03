package com.example.librarybook.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.librarybook.model.Book;
import com.example.librarybook.exception.BookNotFoundException;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    private int nextId = 1;

    // Add Book
    public Book addBook(Book book) {

        book.setBookId(nextId++);

        books.add(book);

        return book;
    }


    public List<Book> getAllBooks() {

        return books;
    }

    // Search Book By ID
    public Book getBookById(Integer id) {

        for (Book book : books) {

            if (book.getBookId().equals(id)) {

                return book;
            }
        }

        throw new BookNotFoundException(
                "Book not found with ID: " + id);
    }

    // Update Availability
    public Book updateAvailability(
            Integer id, boolean available) {

        Book book = getBookById(id);

        book.setAvailable(available);

        return book;
    }

    // Delete Book
    public String deleteBook(Integer id) {

        Book book = getBookById(id);

        books.remove(book);

        return "Book deleted successfully";
    }
}