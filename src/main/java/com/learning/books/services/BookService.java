package com.learning.books.services;

import com.learning.books.dto.BookEntity;
import com.learning.books.exception.BookNotFoundException;
import com.learning.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookEntity getBookByID(UUID uuid) throws BookNotFoundException {
        BookEntity bookEntity = null;
        if (bookRepository.findById(uuid).isPresent()) {
            bookEntity =  bookRepository.findById(uuid).get();
        } else {
            throw new BookNotFoundException("Book not Found");
        }
        return bookEntity;
    }

    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    public BookEntity createBook(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    public BookEntity updateBook(UUID uuid, BookEntity bookEntity) throws BookNotFoundException {
        if (bookRepository.findById(uuid).isPresent()) {
            BookEntity newBook = new BookEntity();
            newBook = bookRepository.getReferenceById(uuid);
            newBook.setAuthorName(bookEntity.getAuthorName());
            newBook.setBookName(bookEntity.getBookName());
            newBook.setBookPrice(bookEntity.getBookPrice());
            newBook.setBookEdition(bookEntity.getBookEdition());
            newBook.setCategory(bookEntity.getCategory());
            newBook.setQuantity(bookEntity.getQuantity());
            return bookRepository.save(newBook);
        }
        else {
            throw new BookNotFoundException("Book not present");
        }
    }

    public String deleteBook(UUID uuid) throws BookNotFoundException {
        if (bookRepository.existsById(uuid)) {
            bookRepository.deleteById(uuid);
            return "Book has been deleted succesfully";
        }
        else {
            throw new BookNotFoundException("Book not present");
        }
    }

}
