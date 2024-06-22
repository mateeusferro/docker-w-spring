package com.ferro.mateus.docker_w_spring.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    private String message;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
