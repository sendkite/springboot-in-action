package com.example.todos.data;

import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.todos.domain.TodoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 빈 초기화 시점에 메서드 호출해서 데이터를 초기화한다.
 */
@Component
public class TodoDataInitializer implements InitializingBean {

    private final TodoRepository todoRepository;

    public TodoDataInitializer(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        todoRepository.save(Todo.create("할일 1"));
        todoRepository.save(Todo.create("할일 2"));
        todoRepository.save(Todo.create("할일 3"));
    }
}
