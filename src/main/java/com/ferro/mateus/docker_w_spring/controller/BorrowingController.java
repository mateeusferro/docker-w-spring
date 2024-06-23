package com.ferro.mateus.docker_w_spring.controller;

import com.ferro.mateus.docker_w_spring.controller.dtos.APIResponse;
import com.ferro.mateus.docker_w_spring.controller.dtos.BorrowingDTO;
import com.ferro.mateus.docker_w_spring.controller.dtos.PaginationResponse;
import com.ferro.mateus.docker_w_spring.domain.entity.Borrowing;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.BorrowingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/borrowing")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public ResponseEntity<APIResponse<Borrowing>> search(
            @RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size
    ) {
        Page<Borrowing> borrowings = borrowingService.search(page, size);
        return new ResponseEntity<>(
                new APIResponse<>(borrowings.getContent(),
                        PaginationResponse.fromPage(borrowings)
                ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> find(@RequestParam(value = "id") UUID id)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(borrowingService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Borrowing> create(@RequestBody @Valid BorrowingDTO borrowing) {
        return new ResponseEntity<>(borrowingService.create(borrowing), HttpStatus.CREATED);
    }

    @PutMapping("/give-back/{id}")
    public ResponseEntity<Borrowing> giveBack(@PathVariable UUID id)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(borrowingService.giveBack(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws ResourceNotFoundException {
        borrowingService.delete(id);
        return new ResponseEntity<>("Borrowing deleted", HttpStatus.OK);
    }

}
