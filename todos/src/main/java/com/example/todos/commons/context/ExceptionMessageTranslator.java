package com.example.todos.commons.context;

import java.util.Locale;

/**
 * 예외 메시지 국제화를 위한 번역기
 */
public interface ExceptionMessageTranslator {

    /**
     * @param throwable 예외 개체
     * @param locale    국가/언어
     */
    String getMessage(Throwable throwable, Locale locale);

    /**
     * 적절한 메시지 찾지 못하면 기본 메시지 반환
     */
    String getMessage(Throwable throwable, String defaultMessage, Locale locale);
}
