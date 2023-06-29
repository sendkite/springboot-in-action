package com.example.todos.core.todos.infrastructure;

import com.example.todos.Constant;
import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.todos.domain.TodoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@Profile(Constant.PROFILE_PRODUCTION)
public interface JpaTodoRepository extends TodoRepository, JpaRepository<Todo, Long> {

}
