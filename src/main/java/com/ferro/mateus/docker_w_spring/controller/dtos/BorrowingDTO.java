package com.ferro.mateus.docker_w_spring.controller.dtos;

import java.util.Date;
import java.util.UUID;

public record BorrowingDTO(UUID bookId, UUID userId, Date borrowedDate,
                           Date returnDate) {
}
