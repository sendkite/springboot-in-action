package com.example.todos.core.user.domain;

public class UserPasswordNotMatchedException extends UserEntityException {

    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchedException() {
        super("비밀번호가 일치하지 않습니다.");
    }
}
