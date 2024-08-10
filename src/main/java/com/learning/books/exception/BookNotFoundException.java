package com.learning.books.exception;

public class BookNotFoundException extends Exception{


    private final String bookNotPresent;

    public BookNotFoundException(String bookNotPresent) {
        this.bookNotPresent = bookNotPresent;
    }
}
