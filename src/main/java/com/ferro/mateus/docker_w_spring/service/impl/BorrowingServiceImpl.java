package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.controller.dtos.BorrowingDTO;
import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import com.ferro.mateus.docker_w_spring.domain.entity.Borrowing;
import com.ferro.mateus.docker_w_spring.domain.entity.User;
import com.ferro.mateus.docker_w_spring.domain.enums.BorrowingStatus;
import com.ferro.mateus.docker_w_spring.domain.repository.BorrowingRepository;
import com.ferro.mateus.docker_w_spring.exceptions.OutOfRangeException;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.BookService;
import com.ferro.mateus.docker_w_spring.service.BorrowingService;
import com.ferro.mateus.docker_w_spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private BookService bookService;

    @Override
    @Transactional(readOnly = true)
    public Page<Borrowing> search(Integer page, Integer size) {
        if (page < 0 || size < 0) {
            throw new OutOfRangeException("Page or page size must be greater than 0");
        }
        if (size > 50) {
            throw new OutOfRangeException("Page size must be less than 50");
        }

        Pageable pageable = PageRequest.of(page, size);
        return borrowingRepository.findAll(pageable);
    }

    @Override
    public Borrowing find(UUID id) {
        return borrowingRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Borrowing not found"));
    }

    @Override
    @Transactional
    public Borrowing create(BorrowingDTO borrowingDTO) {
        Book book = bookService.find(borrowingDTO.bookId());
        bookService.updateStatus(borrowingDTO.bookId());
        User user = userService.find(borrowingDTO.userId());
        Borrowing borrowing = Borrowing.builder()
                .book(book)
                .user(user)
                .borrowedDate(borrowingDTO.borrowedDate())
                .returnDate(borrowingDTO.returnDate())
                .status(BorrowingStatus.PENDING)
                .build();
        return borrowingRepository.save(borrowing);
    }

    @Override
    @Transactional
    public Borrowing giveBack(UUID id) {
        Borrowing borrowing = this.find(id);
        bookService.updateStatus(borrowing.getBook().getId());
        borrowing.setStatus(BorrowingStatus.RETURNED);
        borrowing.setReturnDate(new Date());
        return borrowingRepository.save(borrowing);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        borrowingRepository.delete(this.find(id));
    }
}
