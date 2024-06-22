package com.ferro.mateus.docker_w_spring.service;


import java.util.List;
import java.util.UUID;

public interface DefaultService<T> {
    List<T> search(Integer page, Integer size);

    T find(UUID id);

    T create(T t);

    T update(T t);

    void delete(UUID id);
}
