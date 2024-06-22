package com.ferro.mateus.docker_w_spring.controller;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

//    @GetMapping
//    public ResponseEntity<List<Author>> search(
//            @RequestParam(value = "page", defaultValue = "1") Integer page,
//            @RequestParam(value = "size", defaultValue = "10") Integer size
//    ) throws Exception{
//        return authorService.search(page, size);
//    }
//
//    @GetMapping("/${id}")
//    public ResponseEntity<Author> find(@PathVariable Integer id)
//            throws Exception {
//        return authorService.find(id);
//    }
//
//    @PostMapping
//    public ResponseEntity<Author> create(@RequestBody AuthorDTO authorDTO)
//        throws Exception {
//        Author author = Author.builder()
//                .name(authorDTO.name())
//                .bio(authorDTO.bio())
//                .build();
//
//        return authorService.create()
//    }
}
