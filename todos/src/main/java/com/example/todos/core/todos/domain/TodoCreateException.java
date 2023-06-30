package com.example.todos.core.todos.domain;

public class TodoCreateException extends TodoEntityException {

    private static final long serialVersionUID = 1L;

    public TodoCreateException(String format, Object...args) {
        super(String.format(format, args));
    }
}
