package com.ferro.mateus.docker_w_spring.controller.dtos;

import com.ferro.mateus.docker_w_spring.domain.enums.BookStatus;

import java.util.Date;
import java.util.UUID;

public record BookDTO(String title, UUID authorId, Date publishedDate,
                      BookStatus status) {
}
