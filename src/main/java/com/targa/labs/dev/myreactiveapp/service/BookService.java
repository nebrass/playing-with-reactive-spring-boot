package com.targa.labs.dev.myreactiveapp.service;

import com.targa.labs.dev.myreactiveapp.data.Book;
import com.targa.labs.dev.myreactiveapp.data.BookRepository;
import com.targa.labs.dev.myreactiveapp.rest.BookDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Flux<Book> findAll() {
        return bookRepository.findAll();
    }

    public Mono<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    public Mono<Book> save(BookDTO book) {
        return bookRepository.save(
                new Book(
                        book.getTitle(),
                        book.getIsbn(),
                        book.getAuthor(),
                        book.getPrice()
                )
        );
    }

    public Flux<Book> findByAuthor(String author) {
        return bookRepository.findBooksByAuthorContainingIgnoreCase(author);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id).subscribe();
    }
}
