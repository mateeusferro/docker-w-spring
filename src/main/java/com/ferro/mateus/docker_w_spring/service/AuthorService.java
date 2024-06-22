package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;

import java.util.List;
import java.util.UUID;

public interface AuthorService extends DefaultService<Author> {
    @Override
    List<Author> search(Integer page, Integer size);

    @Override
    Author find(UUID id);

    @Override
    Author create(Author author);

    @Override
    Author update(Author author);

    @Override
    void delete(UUID id);
}
