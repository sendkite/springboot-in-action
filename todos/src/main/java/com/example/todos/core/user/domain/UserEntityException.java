package com.example.todos.core.user.domain;

import com.example.todos.commons.SystemException;

public class UserEntityException extends SystemException {

    private static final long serialVersionUID = 1L;

    public UserEntityException(String format, Object... args) {
        super(format, args);
    }

    public UserEntityException(String message, Throwable cause) {
        super(message, cause);
    }
}
