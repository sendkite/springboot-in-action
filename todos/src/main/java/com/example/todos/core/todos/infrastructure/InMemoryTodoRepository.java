package com.example.todos.core.todos.infrastructure;

import com.example.todos.Constant;
import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.todos.domain.TodoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Profile(Constant.PROFILE_DEVELOPMENT)
@Repository
public class InMemoryTodoRepository implements TodoRepository {

    private List<Todo> todos = new CopyOnWriteArrayList<>();

    @Override
    public List<Todo> findAll() {
        return Collections.unmodifiableList(todos);
    }

    @Override
    public List<Todo> findByUsername(String username) {

        return todos.stream()
                .filter(todo -> Objects.equals(username, todo.getUsername()))
                .toList();
    }

    public Optional<Todo> findById(Long id) {
        return todos.stream().filter(todo -> Objects.equals(id, todo.getId())).findFirst();
    }

    @Override
    public Todo save(Todo todo) {
        if (!todos.contains(todo)) {
            todos.add(todo);
        }
        return todo;
    }

    @Override
    public void delete(Todo todo) {
        todos.remove(todo);
    }

}
