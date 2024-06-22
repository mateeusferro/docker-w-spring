package com.ferro.mateus.docker_w_spring.service;

import com.ferro.mateus.docker_w_spring.domain.entity.Borrowing;

import java.util.List;
import java.util.UUID;

public interface BorrowingService extends DefaultService<Borrowing> {
    @Override
    List<Borrowing> search(Integer page, Integer size);

    @Override
    Borrowing find(UUID id);

    @Override
    Borrowing create(Borrowing borrowing);

    @Override
    Borrowing update(Borrowing borrowing);

    @Override
    void delete(UUID id);
}
