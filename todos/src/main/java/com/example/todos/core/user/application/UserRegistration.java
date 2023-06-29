package com.example.todos.core.user.application;

import com.example.todos.core.user.domain.User;

public interface UserRegistration {

    User join(String username, String rawPassword);
}
