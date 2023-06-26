package com.example.todos.commons.web.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExecutionTimeHandlerInterceptor implements HandlerInterceptor, Ordered {

    private static final String STOP_WATCH_ATTR_NAME = "ExecutionTimeHandlerInterceptor.StopWatch";

    private final Logger log = LoggerFactory.getLogger(ExecutionTimeHandlerInterceptor.class);

    @Override
    public int getOrder() {
        return Integer.MIN_VALUE;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        StopWatch stopWatch = new StopWatch(getHandlerName(handler));
        stopWatch.start();
        request.setAttribute(STOP_WATCH_ATTR_NAME, stopWatch);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        StopWatch stopWatch = (StopWatch) request.getAttribute(STOP_WATCH_ATTR_NAME);
        stopWatch.stop();

        log.debug("[" + getHandlerName(handler) + "] executeTime : " + stopWatch.getTotalTimeMillis() + "ms");
    }

    private String getHandlerName(Object handler) {
        if (handler instanceof HandlerMethod) {
            return ((HandlerMethod) handler).getShortLogMessage();
        }
        return handler.toString();
    }
}
