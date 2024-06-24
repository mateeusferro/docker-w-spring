package com.ferro.mateus.docker_w_spring.domain.enums;

import lombok.Getter;

@Getter
public enum BookStatus {
    BORROWED("Borrowed"),
    AVAILABLE("Available");

    private final String status;

    BookStatus(String status) {
        this.status = status;
    }
}
