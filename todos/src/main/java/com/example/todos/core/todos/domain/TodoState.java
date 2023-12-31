package com.example.todos.core.todos.domain;

public enum TodoState {

    ACTIVE("ACTIVE", "처리해야 할 일"),
    COMPLETED("COMPLETED", "완료한 일");

    private final String literal;

    private final String description;

    TodoState(String literal, String description) {
        this.literal = literal;
        this.description = description;
    }

    public String getLiteral() {
        return literal;
    }

    public String getDescription() {
        return description;
    }
}
