package com.ferro.mateus.docker_w_spring.controller;

import com.ferro.mateus.docker_w_spring.controller.dtos.APIResponse;
import com.ferro.mateus.docker_w_spring.controller.dtos.BookDTO;
import com.ferro.mateus.docker_w_spring.controller.dtos.PaginationResponse;
import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<APIResponse<Book>> search(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        Page<Book> books = bookService.search(page, size);
        return new ResponseEntity<>(
                new APIResponse<>(books.getContent(),
                        PaginationResponse.fromPage(books)
                ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> find(@PathVariable UUID id)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(bookService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody @Valid BookDTO bookDTO) {
        return new ResponseEntity<>(bookService.create(bookDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> update(@PathVariable UUID id,
                                       @RequestBody @Valid BookDTO bookDTO)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(bookService.update(id, bookDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws ResourceNotFoundException {
        bookService.delete(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }
}
