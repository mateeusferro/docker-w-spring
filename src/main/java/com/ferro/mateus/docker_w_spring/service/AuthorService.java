package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface AuthorService {
    Page<Author> search(Integer page, Integer size);

    Author find(UUID id);

    Author create(Author author);

    Author update(Author author);

    void delete(UUID id);
}
