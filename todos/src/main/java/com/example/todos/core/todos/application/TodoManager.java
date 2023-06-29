package com.example.todos.core.todos.application;

import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.todos.domain.TodoEntityNotFoundException;
import com.example.todos.core.todos.domain.TodoRepository;

import java.util.List;

public class TodoManager implements TodoFinder, TodoEditor {

    private final TodoRepository todoRepository;

    public TodoManager(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public List<Todo> getAll() {
        return todoRepository.findAll();
    }

    @Override
    public Todo create(String title) {
        return todoRepository.save(Todo.create(title));
    }

    @Override
    public void update(Long id, String title, boolean completed) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoEntityNotFoundException(id));

        todo.update(title, completed);
    }

    @Override
    public void delete(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new TodoEntityNotFoundException(id));

        todoRepository.delete(todo);
    }
}
