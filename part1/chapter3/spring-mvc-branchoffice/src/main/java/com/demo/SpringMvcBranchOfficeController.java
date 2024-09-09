package com.demo;

import com.demo.domain.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1/books")
@RequiredArgsConstructor
public class SpringMvcBranchOfficeController {

    private final Map<Long, Book> bookMap;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{book-id}")
    public ResponseEntity<Book> getBook(@PathVariable("book-id") long bookId)
            throws InterruptedException {
        Thread.sleep(5000);

        return ResponseEntity.ok(bookMap.get(bookId));
    }
}
