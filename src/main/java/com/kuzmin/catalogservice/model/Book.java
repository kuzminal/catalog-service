package com.kuzmin.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Year;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    private String isbn;
    private String title;
    private String author;
    private Year publishingYear;
}
