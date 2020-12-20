package com.kuzmin.catalogservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.Year;

@AllArgsConstructor
@Getter
@Setter
public class Book {
    @NotBlank(message = "The book ISBN must be defined.")
    @Pattern(regexp = "^(97([89]))?\\d{9}(\\d|X)$",
            message = "The ISBN format must follow the standards ISBN-10or ISBN-13.")
    private String isbn;
    @NotBlank(message = "The book title must be defined.")
    private String title;
    @NotBlank(message = "The book author must be defined.")
    private String author;
    @PastOrPresent(message = "The book cannot have been published in the future.")
    private Year publishingYear;
}
