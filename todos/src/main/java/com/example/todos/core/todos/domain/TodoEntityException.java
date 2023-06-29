package com.example.todos.core.todos.domain;

public class TodoEntityException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public TodoEntityException(String format, Object... args) {
        super(String.format(format, args));
    }
}
