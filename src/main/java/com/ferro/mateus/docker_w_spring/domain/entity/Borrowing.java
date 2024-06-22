package com.ferro.mateus.docker_w_spring.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "borrowings")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Borrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "borrowing_id")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date")
    private Date borrowedDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_return_date")
    private Date returnDate;
}
