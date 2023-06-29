package com.example.todos.core.todos.application;

import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.user.domain.User;

import java.util.List;

public interface PersonalTodoFinder {

    List<Todo> getAll(User user);
}
