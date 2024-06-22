package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService extends DefaultService<User> {
    @Override
    List<User> search(Integer page, Integer size);

    @Override
    User find(UUID id);

    @Override
    User create(User user);

    @Override
    User update(User user);

    @Override
    void delete(UUID id);
}
