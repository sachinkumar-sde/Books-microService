package com.learning.books.controllers;

import com.learning.books.dto.BookEntity;
import com.learning.books.exception.BookNotFoundException;
import com.learning.books.services.BookService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService=bookService;
    }
    @GetMapping("/book")
    public ResponseEntity<List<BookEntity>> getBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<BookEntity> getBookByID(@RequestParam(value = "uuid") UUID uuid) throws BookNotFoundException {
//        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBookByID(uuid));
        return new ResponseEntity<>(bookService.getBookByID(uuid), HttpStatus.OK);
    }

    @PostMapping("/createBook")
    public ResponseEntity<BookEntity> createBook(@RequestBody BookEntity bookEntity) {
        return new ResponseEntity<>(bookService.createBook(bookEntity), HttpStatus.CREATED);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity bookEntity, @RequestParam(value = "uuid") UUID uuid) throws BookNotFoundException {
        return new ResponseEntity<>(bookService.updateBook(uuid, bookEntity), HttpStatus.OK);
    }

    @DeleteMapping("/book/{id}")
    public String deleteByID(@RequestParam(value = "uuid") UUID uuid) throws BookNotFoundException {
        return bookService.deleteBook(uuid);
    }
}
