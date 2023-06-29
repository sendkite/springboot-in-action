package com.example.todos.core.todos.domain;

import java.util.List;
import java.util.Optional;

public interface TodoRepository {

    List<Todo> findAll();

    List<Todo> findByUsername(String username);

    Optional<Todo> findById(Long id);

    Todo save(Todo todo);

    void delete(Todo todo);
}
