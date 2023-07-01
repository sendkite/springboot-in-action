package com.example.todos.core.todos.domain;

import com.example.todos.commons.SystemException;

public class TodoEntityException extends SystemException {

    private static final long serialVersionUID = 1L;

    public TodoEntityException(String format, Object... args) {
        super(String.format(format, args));
    }
}
