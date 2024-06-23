package com.ferro.mateus.docker_w_spring.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "author_id")
    private UUID id;

    @NotBlank(message = "Author name is mandatory")
    @Size(min = 3, max = 50, message = "Author name must be between 3 and 50 characters")
    @Column(name = "author_name")
    private String name;

    @Size(max = 255, message = "Author bio must be less than 255 characters")
    @Column(name = "author_bio")
    private String bio;
}