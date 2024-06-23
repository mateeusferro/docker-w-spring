package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.controller.dtos.BorrowingDTO;
import com.ferro.mateus.docker_w_spring.domain.entity.Borrowing;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface BorrowingService {
    Page<Borrowing> search(Integer page, Integer size);

    Borrowing find(UUID id);

    Borrowing create(BorrowingDTO borrowing);

    Borrowing giveBack(UUID id);

    void delete(UUID id);
}
