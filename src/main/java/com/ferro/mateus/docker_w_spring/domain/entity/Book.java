package com.ferro.mateus.docker_w_spring.domain.entity;

import com.ferro.mateus.docker_w_spring.domain.enums.BookStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "author")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "book_id")
    private UUID id;

    @Column(name = "book_title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author authorId;

    @Temporal(TemporalType.DATE)
    @Column(name = "book_published_date")
    private Date publishedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_status")
    private BookStatus status;
}
