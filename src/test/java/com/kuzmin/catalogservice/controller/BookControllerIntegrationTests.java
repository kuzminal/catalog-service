package com.kuzmin.catalogservice.controller;

import com.kuzmin.catalogservice.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("integration")
public class BookControllerIntegrationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void whenGetRequestWithIdThenBookReturned() {
        String bookIsbn = "1231231230";
        Book expectedBook = new Book(bookIsbn, "Book Title", "Book Author", Year.of(1991), 9.90);
        restTemplate.postForEntity("/books", expectedBook, Book.class);
        ResponseEntity<Book> response = restTemplate.getForEntity("/books/" + bookIsbn, Book.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().getIsbn()).isEqualTo(bookIsbn);
    }
}
