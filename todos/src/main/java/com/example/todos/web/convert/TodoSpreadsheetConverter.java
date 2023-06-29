package com.example.todos.web.convert;

import com.example.todos.commons.domain.Spreadsheet;
import com.example.todos.core.todos.domain.Todo;
import com.example.todos.commons.util.StreamUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TodoSpreadsheetConverter {

    public Spreadsheet convert(Iterable<Todo> todos) {
        Spreadsheet.Row header = new Spreadsheet.Row()
                .addCell("id")
                .addCell("title")
                .addCell("completed");

        Stream<Todo> todoStream = StreamUtils.createStreamFromIterator(todos.iterator());
        List<Spreadsheet.Row> rows = todoStream.map(this::mapRow).collect(Collectors.toList());

        return new Spreadsheet("todos", header, rows);
    }

    private Spreadsheet.Row mapRow(Todo todo) {
        return new Spreadsheet.Row()
                .addCell(todo.getId())
                .addCell(todo.getTitle())
                .addCell(todo.isCompleted() ? "완료" : "미완료");
    }
}
