package com.ferro.mateus.docker_w_spring.exceptions;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ResourceNotFoundException.class })
    public ResponseEntity<Object> handleResourceNotFoundException(
            ResourceNotFoundException ex, WebRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("errors", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ OutOfRangeException.class })
    public ResponseEntity<Object> handleOutOfRangeException(
            OutOfRangeException ex, WebRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("errors", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ IllegalArgumentException.class })
    public ResponseEntity<Object> handleIllegalArgumentException(
            IllegalArgumentException ex, WebRequest request) {
        Map<String, String> body = new HashMap<>();
        body.put("errors", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
