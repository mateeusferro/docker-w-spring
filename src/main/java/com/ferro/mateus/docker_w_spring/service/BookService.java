package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.Book;

import java.util.List;
import java.util.UUID;

public interface BookService extends DefaultService<Book>{
    @Override
    List<Book> search(Integer page, Integer size);

    @Override
    Book find(UUID id);

    @Override
    Book create(Book book);

    @Override
    Book update(Book book);

    @Override
    void delete(UUID id);
}
