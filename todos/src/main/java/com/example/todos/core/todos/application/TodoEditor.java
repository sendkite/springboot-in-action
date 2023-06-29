package com.example.todos.core.todos.application;

import com.example.todos.core.todos.domain.Todo;

public interface TodoEditor {

    Todo create(String title);

    void update(Long id, String title, boolean completed);

    void delete(Long id);
}
