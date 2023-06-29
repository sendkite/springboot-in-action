package com.example.todos.security;

import com.example.todos.commons.SystemException;

public class UnauthorizedAccessException extends SystemException {

    private static final long serialVersionUID = 1L;

    public UnauthorizedAccessException() {
        super("인증되지 않은 접근입니다.");
    }
}
