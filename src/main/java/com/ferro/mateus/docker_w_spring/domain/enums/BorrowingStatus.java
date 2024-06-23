package com.ferro.mateus.docker_w_spring.domain.enums;

public enum BorrowingStatus {
    PENDING("Pending"),
    RETURNED("Returned"),
    LATE("Late"),
    CANCELED("Canceled");


    BorrowingStatus(String canceled) {
    }
}
