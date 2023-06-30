package com.example.todos.web;

import com.example.todos.core.todos.application.TodoEditor;
import com.example.todos.core.todos.application.TodoFinder;
import com.example.todos.core.todos.domain.Todo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoRestController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TodoFinder finder;
    private final TodoEditor editor;

    public TodoRestController(TodoFinder finder, TodoEditor editor) {
        this.finder = finder;
        this.editor = editor;
    }

    @GetMapping
    public List<Todo> list() {
        return finder.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody @Valid WriteTodoCommand todoCommand) {
        logger.debug("request payload: {}", todoCommand);

        editor.create(todoCommand.getTitle());
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody @Valid WriteTodoCommand todoCommand) {
        logger.debug("request update id: {}, commend: {}", id, todoCommand);

        editor.update(id, todoCommand.getTitle(), todoCommand.isCompleted());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        logger.debug("request delete id: {}", id);

        editor.delete(id);
    }

    static class WriteTodoCommand {

        @NotBlank()
        @Size(min= 4, max = 100)
        private String title;
        private boolean completed;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isCompleted() {
            return completed;
        }

        public void setCompleted(boolean completed) {
            this.completed = completed;
        }

        @Override
        public String toString() {
            return "WriteTodoCommand{" +
                    "title='" + title + '\'' +
                    ", completed=" + completed +
                    '}';
        }
    }
}
