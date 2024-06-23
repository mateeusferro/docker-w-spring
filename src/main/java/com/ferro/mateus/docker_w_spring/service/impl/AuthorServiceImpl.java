package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.domain.repository.AuthorRepository;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    @Transactional(readOnly = true)
    public Page<Author> search(Integer page, Integer size) {
        if (page < 0 || size < 0) {
            throw new IllegalArgumentException("Page or page size must be greater than 0");
        }
        if (size > 50) {
            throw new IllegalArgumentException("Page size must be less than 50");
        }

        Pageable pageable = PageRequest.of(page, size);
        return authorRepository.findAll(pageable);
    }

    @Override
    public Author find(UUID id) throws ResourceNotFoundException {
        return authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    @Transactional
    public Author create(Author author) throws IllegalArgumentException {
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public Author update(Author author) {
        this.find(author.getId());
        return authorRepository.save(author);
    }

    @Override
    @Transactional
    public void delete(UUID id) throws ResourceNotFoundException {
        authorRepository.delete(this.find(id));
    }
}
