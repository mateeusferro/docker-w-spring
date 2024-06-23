package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.repository.BookRepository;
import com.ferro.mateus.docker_w_spring.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void search() {
    }

    @Test
    void find() {
    }

    @Test
    void create() {
    }

    @Test
    void updateStatus() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}