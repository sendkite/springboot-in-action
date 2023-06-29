package com.example.todos.core.todos.domain;

public class TodoCreateException extends TodoEntityException {

    private static final long serialVersionUID = 1L;

    public TodoCreateException() {
        super("할 일을 생성할 수 없습니다.");
    }
}
