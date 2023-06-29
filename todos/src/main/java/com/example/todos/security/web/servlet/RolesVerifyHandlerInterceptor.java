package com.example.todos.security.web.servlet;

import com.example.todos.security.support.RolesAllowedSupport;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

public class RolesVerifyHandlerInterceptor implements HandlerInterceptor, RolesAllowedSupport {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public final boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        throw new UnsupportedOperationException("unimplemented feature for RolesVerifyHandlerInterceptor");
    }
}
