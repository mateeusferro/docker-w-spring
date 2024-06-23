package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.repository.BorrowingRepository;
import com.ferro.mateus.docker_w_spring.service.impl.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BorrowingServiceTest {

    @Mock
    private BorrowingRepository borrowingRepository;

    @InjectMocks
    private BorrowingServiceImpl borrowingService;

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
    void giveBack() {
    }

    @Test
    void delete() {
    }
}