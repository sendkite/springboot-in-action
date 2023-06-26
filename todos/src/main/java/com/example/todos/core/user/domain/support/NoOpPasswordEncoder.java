package com.example.todos.core.user.domain.support;

import com.example.todos.core.user.domain.PasswordEncoder;

public class NoOpPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(String password) {
        return password;
    }
}
