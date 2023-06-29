package com.example.todos.core.todos.domain;

public class TodoEntityNotFoundException extends TodoEntityException {

    private static final long serialVersionUID = 1L;

    private final Long id;

    public TodoEntityNotFoundException(Long id) {
        super("할 일을 찾을 수 없습니다. (id: %d)", id);
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
