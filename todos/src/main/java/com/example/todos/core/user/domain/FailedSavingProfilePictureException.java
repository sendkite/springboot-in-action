package com.example.todos.core.user.domain;

public class FailedSavingProfilePictureException extends UserEntityException {

    private static final long serialVersionUID = 1L;

    public FailedSavingProfilePictureException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
