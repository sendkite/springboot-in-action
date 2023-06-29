package com.example.todos.commons.web.error;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Objects;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class ReadableErrorAttributes implements ErrorAttributes, HandlerExceptionResolver, Ordered {

    private final DefaultErrorAttributes delegate = new DefaultErrorAttributes();
    private final Logger log = LoggerFactory.getLogger(ReadableErrorAttributes.class);


    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> attributes = delegate.getErrorAttributes(webRequest, options);
        Throwable error = getError(webRequest);

        log.debug("errorAttributes: {}, error: {}", attributes, error);

        if (Objects.nonNull(error)) {
            // TODO attributes, error 을 사용해 message 속성을 읽기 좋은 문구로 가공한다.
            // TODO ex) attributes.put("message", "문구");
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
}
