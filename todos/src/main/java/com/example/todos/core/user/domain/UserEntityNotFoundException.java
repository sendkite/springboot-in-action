package com.example.todos.core.user.domain;

public class UserEntityNotFoundException extends UserEntityException {

    private static final long serialVersionUID = 1L;

    private String username;

    public UserEntityNotFoundException(String username) {
        super(String.format("User 엔티티를 찾을 수 없습니다. (username: %s)", username));
        this.username = username;
    }

    @Override
    public Object[] getArguments() {
        return new Object[]{ String.valueOf(username) };
    }
}
