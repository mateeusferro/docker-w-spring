package com.ferro.mateus.docker_w_spring.domain.entity;

import com.ferro.mateus.docker_w_spring.domain.enums.BookStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private UUID id;

    @NotBlank(message = "Book title is mandatory")
    @Size(min = 1, max = 100, message = "Book title must be between 1 and 100 characters")
    @Column(name = "book_title")
    private String title;

    @NotNull(message = "Book author is mandatory")
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    @NotNull(message = "Book published date is mandatory")
    @Temporal(TemporalType.DATE)
    @Column(name = "book_published_date")
    private Date publishedDate;

    @NotBlank(message = "Book status is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(name = "book_status")
    private BookStatus status;
}
