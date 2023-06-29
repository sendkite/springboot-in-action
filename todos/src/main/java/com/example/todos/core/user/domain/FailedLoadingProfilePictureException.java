package com.example.todos.core.user.domain;

public class FailedLoadingProfilePictureException extends UserEntityException {

    private static final long serialVersionUID = 1L;

    public FailedLoadingProfilePictureException(String format, Object... args) {
        super(format, args);
    }

    public FailedLoadingProfilePictureException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
