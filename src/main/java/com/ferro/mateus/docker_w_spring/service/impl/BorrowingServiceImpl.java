package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.domain.entity.Borrowing;
import com.ferro.mateus.docker_w_spring.domain.repository.BorrowingRepository;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.BorrowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Override
    public List<Borrowing> search(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Borrowing> pageBorrowing = borrowingRepository.findAll(pageable);
        return pageBorrowing.getContent();
    }

    @Override
    public Borrowing find(UUID id) {
        return borrowingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Borrowing not found"));
    }

    @Override
    public Borrowing create(Borrowing borrowing) {
        return null;
    }

    @Override
    public Borrowing update(Borrowing borrowing) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
