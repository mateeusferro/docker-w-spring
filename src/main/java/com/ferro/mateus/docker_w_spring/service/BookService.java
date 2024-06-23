package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.controller.dtos.BookDTO;
import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BookService {
    Page<Book> search(Integer page, Integer size);

    Book find(UUID id);

    Book create(BookDTO book);

    void updateStatus(UUID id);

    Book update(UUID id, BookDTO book);

    void delete(UUID id);
}
