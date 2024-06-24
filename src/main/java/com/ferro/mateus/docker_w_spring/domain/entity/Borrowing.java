package com.ferro.mateus.docker_w_spring.domain.entity;

import com.ferro.mateus.docker_w_spring.domain.enums.BookStatus;
import com.ferro.mateus.docker_w_spring.domain.enums.BorrowingStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Book is required")
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @NotNull(message = "User is required")
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "Borrowed date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_date")
    private Date borrowedDate;

    @NotNull(message = "Return date is required")
    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_return_date")
    private Date returnDate;

    @NotNull(message = "Borrowing status is mandatory")
    @Enumerated(EnumType.STRING)
    @Column(name = "borrowing_status")
    private BorrowingStatus status;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrowing_returned_date")
    private Date returnedDate;
}
