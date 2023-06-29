package com.example.todos.core.todos.application;

import com.example.todos.core.user.domain.User;

public interface PersonalTodoEditor {

    void create(User user, String title);

    void update(User user, Long id, String title, boolean completed);

    void delete(User user, Long id);
}
