package com.example.todos.commons.web.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReadableErrorAttributes implements ErrorAttributes, HandlerExceptionResolver, Ordered {

    private final DefaultErrorAttributes delegate = new DefaultErrorAttributes();
    private final Logger log = LoggerFactory.getLogger(ReadableErrorAttributes.class);
    private final MessageSource messageSource;

    public ReadableErrorAttributes(MessageSource messageSource) {
        this.messageSource = messageSource;
    }


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> attributes = delegate.getErrorAttributes(webRequest, options);
        Throwable error = getError(webRequest);

        log.debug("errorAttributes: {}, error: {}", attributes, error);

        if (Objects.nonNull(error)) {
            /*
            if (error instanceof TodoEntityNotFoundException) {
                attributes.put("message", "요청한 할 일을 찾을 수 없어요.");
            } else if (error instanceof MethodArgumentNotValidException) {
                attributes.put("message", "입력 값이 없거나 올바르지 않아요.");
            }
            */

            String errorMessage = error.getMessage();
            if (MessageSourceResolvable.class.isAssignableFrom(error.getClass())) {
                errorMessage = messageSource.getMessage((MessageSourceResolvable) error, webRequest.getLocale());
            } else {
                String errorCode = String.format("Exception.%s", error.getClass().getSimpleName());
                errorMessage = messageSource.getMessage(errorCode, new Object[0], errorMessage, webRequest.getLocale());
            }
            attributes.put("message", errorMessage);

            BindingResult bindingResult = extractBindingResult(error);
            if (Objects.nonNull(bindingResult)) {
                List<String> errors = bindingResult
                        .getAllErrors()
                        .stream()
                        .map(oe -> messageSource.getMessage(oe, webRequest.getLocale()))
                        .collect(Collectors.toList());

                attributes.put("errors", errors);
            }
        }

        return attributes;
    }

    @Override
    public Throwable getError(WebRequest webRequest) {
        return delegate.getError(webRequest);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        return delegate.resolveException(request, response, handler, ex);
    }

    static BindingResult extractBindingResult(Throwable error) {
        if (error instanceof BindingResult) {
            return (BindingResult) error;
        }
        if (error instanceof MethodArgumentNotValidException) {
            return ((MethodArgumentNotValidException) error).getBindingResult();
        }
        return null;
    }
}
