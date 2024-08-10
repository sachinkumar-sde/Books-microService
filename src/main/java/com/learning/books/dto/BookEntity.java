package com.learning.books.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookEntity {
    @Id
    @NotNull
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID uuid;
    @NotNull
    private String authorName;
    @NotNull
    private String bookName;
    private Double bookPrice;
    private Integer bookEdition;
    private Integer quantity;
    private String category;

    public BookEntity(String authorName, String bookName, Double bookPrice, Integer bookEdition, Integer quantity, String category) {
        this.authorName = authorName;
        this.bookName = bookName;
        this.bookPrice = bookPrice;
        this.bookEdition = bookEdition;
        this.quantity = quantity;
        this.category = category;
    }

    public BookEntity() {

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookEdition() {
        return bookEdition;
    }

    public void setBookEdition(Integer bookEdition) {
        this.bookEdition = bookEdition;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
