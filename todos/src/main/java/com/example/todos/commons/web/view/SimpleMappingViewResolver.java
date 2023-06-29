package com.example.todos.commons.web.view;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.Map;

public class SimpleMappingViewResolver implements ViewResolver {

    private final Map<String, View> viewMappings;

    public SimpleMappingViewResolver(Map<String, View> viewMappings) {
        this.viewMappings = viewMappings;
    }

    public SimpleMappingViewResolver add(String viewName, View view) {
        viewMappings.remove(viewName);
        viewMappings.put(viewName, view);
        return this;
    }

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewMappings.containsKey(viewName)) {
            return viewMappings.get(viewName);
        }
        return null;
    }
}
