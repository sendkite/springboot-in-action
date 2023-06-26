package com.example.todos.core.user.domain;

public interface PasswordEncoder {

    String encode(String password);
}
