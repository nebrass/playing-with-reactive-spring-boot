package com.targa.labs.dev.myreactiveapp.data;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Long> {

    Flux<Book> findBooksByAuthorContainingIgnoreCase(String author);
}