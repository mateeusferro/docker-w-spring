package com.ferro.mateus.docker_w_spring.domain.repository;

import com.ferro.mateus.docker_w_spring.domain.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
}
