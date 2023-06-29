package com.example.todos.core.todos.application;

import com.example.todos.core.todos.domain.Todo;

import java.util.List;

public interface TodoFinder {

    List<Todo> getAll();
}
