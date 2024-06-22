package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.User;
import com.ferro.mateus.docker_w_spring.domain.repository.UserRepository;
import com.ferro.mateus.docker_w_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> search(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<User> pageUser = userRepository.findAll(pageable);
        return pageUser.getContent();
    }

    @Override
    public User find(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResolutionException("User not found"));
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
