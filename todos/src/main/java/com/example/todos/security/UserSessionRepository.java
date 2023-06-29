package com.example.todos.security;

public interface UserSessionRepository {

    UserSession get();
    void set(UserSession session);
    void clear();

}
