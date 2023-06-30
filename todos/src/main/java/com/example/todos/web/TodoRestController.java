package com.example.todos.web;

import com.example.todos.core.todos.application.TodoFinder;
import com.example.todos.core.todos.domain.Todo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoRestController {

    private final TodoFinder finder;

    public TodoRestController(TodoFinder finder) {
        this.finder = finder;
    }

    @RequestMapping("/api/todos")
    public List<Todo> list() {
        return finder.getAll();
    }
}
