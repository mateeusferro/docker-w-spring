package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.repository.UserRepository;
import com.ferro.mateus.docker_w_spring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository  userRepository;

    @InjectMocks
    private UserServiceImpl userService;

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
    void update() {
    }

    @Test
    void delete() {
    }
}