package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.domain.repository.AuthorRepository;
import com.ferro.mateus.docker_w_spring.service.impl.AuthorServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    void search() {

    }

    @Test
    void find() {
    }

    @Test
    void create() {
        Author author = Author.builder()
                .name("Mateus")
                .bio("")
                .build();

        when(authorRepository.save(Mockito.any(Author.class))).thenReturn(author);

        Author authorCreated = authorService.create(author);
        Assertions.assertThat(authorCreated).isNotNull();
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}