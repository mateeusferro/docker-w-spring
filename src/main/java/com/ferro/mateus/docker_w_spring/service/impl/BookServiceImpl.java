package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import com.ferro.mateus.docker_w_spring.domain.repository.BookRepository;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> search(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Book> pageBook = bookRepository.findAll(pageable);
        return pageBook.getContent();
    }

    @Override
    public Book find(UUID id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    public Book create(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
