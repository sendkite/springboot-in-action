package com.example.todos.data;

import com.example.todos.core.todos.domain.Todo;
import com.example.todos.core.todos.domain.TodoRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/**
 * @see InitializingBean : 빈 초기화 시점에 실행
 * @see ApplicationRunner : 스프링 부트가 실행된 이후에 실행
 * @see CommandLineRunner : 스프링 부트가 실행된 이후에 실행
 * @see ConditionalOnProperty : 조건에 따라 동작 설정
 */
@Component
@ConditionalOnProperty(name = "todo.data.initialize", havingValue = "true")
public class TodoDataInitializer implements InitializingBean, ApplicationRunner, CommandLineRunner {

    private final TodoRepository todoRepository;

    public TodoDataInitializer(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        todoRepository.save(Todo.create("할일 1"));
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        todoRepository.save(Todo.create("할일 2"));
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(Todo.create("할일 3"));
    }
}
