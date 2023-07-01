package com.example.todos.web;

import com.example.todos.web.model.SiteProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Locale;
import java.util.Map;

@Controller
public class TodoController {

    private final SiteProperties siteProperties;

    public TodoController(SiteProperties siteProperties) {
        this.siteProperties = siteProperties;
    }

    @ModelAttribute("site")
    public SiteProperties siteProperties() {
        return siteProperties;
    }

    @RequestMapping("/todos")
    public void todos() throws Exception {
    }

    @RequestMapping(value = "/todos", produces = "text/csv")
    public void todosCsv() throws Exception {

    }

    public static class TodoViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            if ("todos".equals(viewName))
                return new TodoCsvView();
            return null;
        }
    }

    public static class TodoCsvView extends AbstractView implements View {

        final Logger logger = LoggerFactory.getLogger(this.getClass());
        public TodoCsvView() {
            setContentType("text/csv");
        }

        @Override
        protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            logger.debug("model as csv");
        }
    }
}
