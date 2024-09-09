package com.demo;

import com.demo.domain.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class SpringReactiveBranchOfficeController {

    private final Map<Long, Book> bookMap;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    public Mono<Book> getBook(@PathVariable("book-id") long bookId)
            throws InterruptedException {
        Thread.sleep(5000);

        return Mono.just(bookMap.get(bookId));
    }
}
