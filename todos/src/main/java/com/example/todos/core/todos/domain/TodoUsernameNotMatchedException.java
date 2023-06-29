package com.example.todos.core.todos.domain;

public class TodoUsernameNotMatchedException extends TodoEntityException {

    private static final long serialVersionUID = 1L;

    public TodoUsernameNotMatchedException() {
        super("작성자가 일치하지 않습니다.");
    }
}
