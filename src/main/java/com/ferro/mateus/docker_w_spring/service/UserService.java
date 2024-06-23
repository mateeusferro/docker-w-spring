package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.User;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {
    Page<User> search(Integer page, Integer size);

    User find(UUID id);

    User create(User user);

    User update(User user);

    void delete(UUID id);
}
