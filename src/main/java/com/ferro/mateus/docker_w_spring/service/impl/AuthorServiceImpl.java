package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.domain.repository.AuthorRepository;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.AuthorService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> search(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Author> pageAuthor = authorRepository.findAll(pageable);
        return pageAuthor.getContent();
    }

    @Override
    public Author find(UUID id) {
        return authorRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    public Author create(Author author) {
        return null;
    }

    @Override
    public Author update(Author author) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
