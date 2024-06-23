package com.ferro.mateus.docker_w_spring.controller;

import com.ferro.mateus.docker_w_spring.controller.dtos.APIResponse;
import com.ferro.mateus.docker_w_spring.controller.dtos.AuthorDTO;
import com.ferro.mateus.docker_w_spring.controller.dtos.PaginationResponse;
import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.exceptions.OutOfRangeException;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping
    public ResponseEntity<APIResponse<Author>> search(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        Page<Author> authors = authorService.search(page, size);
        return new ResponseEntity<>(
                new APIResponse<>(authors.getContent(),
                        PaginationResponse.fromPage(authors)
                ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> find(@PathVariable UUID id) {
        return new ResponseEntity<>(authorService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> create(@RequestBody @Valid AuthorDTO authorDTO) {
        Author author = Author.builder()
                .name(authorDTO.name())
                .bio(authorDTO.bio())
                .build();

        return new ResponseEntity<>(authorService.create(author), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> update(@PathVariable UUID id,
                                         @RequestBody @Valid AuthorDTO authorDTO) {
        Author author = Author.builder()
                .id(id)
                .name(authorDTO.name())
                .bio(authorDTO.bio())
                .build();

        return new ResponseEntity<>(authorService.update(author), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id) {
        authorService.delete(id);
        return new ResponseEntity<>("Author deleted", HttpStatus.OK);
    }
}
