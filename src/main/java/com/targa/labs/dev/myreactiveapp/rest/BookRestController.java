package com.targa.labs.dev.myreactiveapp.rest;

import com.targa.labs.dev.myreactiveapp.data.Book;
import com.targa.labs.dev.myreactiveapp.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Flux<Book> list() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Book> findById(@PathVariable Long id) {
        return bookService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Book> create(@RequestBody BookDTO bookDTO) {
        return bookService.save(bookDTO);
    }

    @GetMapping("/author")
    public Flux<Book> findByAuthor(@RequestParam String name) {
        return bookService.findByAuthor(name);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}