package com.ferro.mateus.docker_w_spring.domain.enums;

import lombok.Getter;

@Getter
public enum BorrowingStatus {
    PENDING("Pending"),
    RETURNED("Returned"),
    LATE("Late"),
    CANCELED("Canceled");

    private final String status;

    BorrowingStatus(String status) {
        this.status = status;
    }
}
