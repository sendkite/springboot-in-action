package com.example.todos.security.support;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.ClassUtils;
import org.springframework.web.method.HandlerMethod;

import java.util.Objects;

public interface RolesAllowedSupport {

    default RolesAllowed getRolesAllowed(Object handler) {
        if (ClassUtils.isAssignableValue(HandlerMethod.class, handler)) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RolesAllowed annotation = handlerMethod.getMethodAnnotation(RolesAllowed.class);
            if (Objects.isNull(annotation)) {
                annotation = AnnotatedElementUtils.findMergedAnnotation(handlerMethod.getBeanType(), RolesAllowed.class);
            }
            return annotation;
        }
        return null;
    }
}
