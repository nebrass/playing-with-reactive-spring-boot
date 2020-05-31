package com.targa.labs.dev.myreactiveapp.rest;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookDTO {
    private String title;
    private String isbn;
    private String author;
    private BigDecimal price;
}
