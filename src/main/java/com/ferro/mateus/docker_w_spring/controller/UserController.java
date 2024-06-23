package com.ferro.mateus.docker_w_spring.controller;

import com.ferro.mateus.docker_w_spring.controller.dtos.APIResponse;
import com.ferro.mateus.docker_w_spring.controller.dtos.PaginationResponse;
import com.ferro.mateus.docker_w_spring.controller.dtos.UserDTO;
import com.ferro.mateus.docker_w_spring.domain.entity.User;
import com.ferro.mateus.docker_w_spring.exceptions.ResourceNotFoundException;
import com.ferro.mateus.docker_w_spring.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<APIResponse<User>> search(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size
    ) {
        Page<User> users = userService.search(page, size);
        return new ResponseEntity<>(
                new APIResponse<>(users.getContent(),
                        PaginationResponse.fromPage(users)
                ), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> find(@RequestParam(value = "id") UUID id)
            throws ResourceNotFoundException {
        return new ResponseEntity<>(userService.find(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO userDTO) {
        User user = User.builder()
                .name(userDTO.name())
                .email(userDTO.email())
                .build();
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable UUID id,
                                       @RequestBody @Valid UserDTO userDTO)
            throws ResourceNotFoundException {
        User user = User.builder()
                .id(id)
                .name(userDTO.name())
                .email(userDTO.email())
                .build();
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id)
            throws ResourceNotFoundException {
        userService.delete(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
}
