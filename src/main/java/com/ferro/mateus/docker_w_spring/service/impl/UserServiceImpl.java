package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.User;
import com.ferro.mateus.docker_w_spring.domain.repository.UserRepository;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<User> search(Integer page, Integer size) {
        if (page < 0 || size < 0) {
            throw new IllegalArgumentException("Page or page size must be greater than 0");
        }
        if (size > 50) {
            throw new IllegalArgumentException("Page size must be less than 50");
        }

        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    @Override
    public User find(UUID id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found"));
    }

    @Override
    @Transactional
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(User user) {
        this.find(user.getId());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        userRepository.delete(this.find(id));
    }
}
