package com.ferro.mateus.docker_w_spring.service.impl;

import com.ferro.mateus.docker_w_spring.controller.dtos.BookDTO;
import com.ferro.mateus.docker_w_spring.domain.entity.Author;
import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import com.ferro.mateus.docker_w_spring.domain.enums.BookStatus;
import com.ferro.mateus.docker_w_spring.domain.repository.BookRepository;
import com.ferro.mateus.docker_w_spring.exceptions.OutOfRangeException;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.AuthorService;
import com.ferro.mateus.docker_w_spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    @Transactional(readOnly = true)
    public Page<Book> search(Integer page, Integer size) {
        if (page < 0 || size < 0) {
            throw new OutOfRangeException("Page or page size must be greater than 0");
        }
        if (size > 50) {
            throw new OutOfRangeException("Page size must be less than 50");
        }

        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book find(UUID id) {
        return bookRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Book not found"));
    }

    @Override
    @Transactional
    public Book create(BookDTO bookDTO) {
        Author author = authorService.find(bookDTO.authorId());
        Book book = Book.builder()
                .title(bookDTO.title())
                .author(author)
                .publishedDate(bookDTO.publishedDate())
                .status(BookStatus.AVAILABLE)
                .build();
        return bookRepository.save(book);
    }

    @Override
    public void updateStatus(UUID id) {
        Book book = this.find(id);
        if (book.getStatus().equals(BookStatus.AVAILABLE)) {
            book.setStatus(BookStatus.BORROWED);
        } else {
            book.setStatus(BookStatus.AVAILABLE);
        }
        bookRepository.save(book);
    }

    @Override
    @Transactional
    public Book update(UUID id, BookDTO bookDTO) {
        Book oldBook = this.find(id);
        Author author = authorService.find(bookDTO.authorId());

        if (!author.equals(oldBook.getAuthor())) {
            throw new IllegalArgumentException("Author cannot be changed");
        }

        Book book = Book.builder()
                .id(id)
                .title(bookDTO.title())
                .author(author)
                .publishedDate(bookDTO.publishedDate())
                .status(bookDTO.status())
                .build();
        return bookRepository.save(book);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        bookRepository.delete(this.find(id));
    }
}
