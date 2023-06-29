package com.example.todos.core.user.application;

import com.example.todos.core.user.domain.User;
import com.example.todos.core.user.domain.UserPasswordNotMatchedException;

public interface UserPasswordVerifier {

    User verify(String username, String rawPassword) throws UserPasswordNotMatchedException;
}
