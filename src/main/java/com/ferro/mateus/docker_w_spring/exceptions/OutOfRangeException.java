package com.ferro.mateus.docker_w_spring.exceptions;

public class OutOfRangeException extends RuntimeException{
    private String message;

    public OutOfRangeException(String message) {
        super(message);
    }
}
