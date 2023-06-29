package com.example.todos.security;

import com.example.todos.commons.SystemException;

public class AccessDeniedException extends SystemException {

    private static final long serialVersionUID = 1L;

    public AccessDeniedException() {
        super("접근을 거부합니다.");
    }
}
