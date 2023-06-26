package com.example.todos.commons;

import org.springframework.context.MessageSourceResolvable;

/**
 * 최상위 예외 클래스
 */
@SuppressWarnings("serial")
public class SystemException extends RuntimeException implements MessageSourceResolvable {

    public SystemException(String format, Object... args) {
        super(String.format(format, args));
    }

    public SystemException(Throwable cause) {
        super(cause);
    }
    @Override
    public String[] getCodes() {
        return new String[0];
    }

    @Override
    public Object[] getArguments() {
        return MessageSourceResolvable.super.getArguments();
    }

    @Override
    public String getDefaultMessage() {
        return MessageSourceResolvable.super.getDefaultMessage();
    }
}
