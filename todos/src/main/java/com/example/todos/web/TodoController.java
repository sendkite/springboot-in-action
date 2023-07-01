package com.example.todos.web;

import com.example.todos.core.todos.application.TodoFinder;
import com.example.todos.core.todos.domain.Todo;
import com.example.todos.web.convert.TodoSpreadsheetConverter;
import com.example.todos.web.model.SiteProperties;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class TodoController {

    private final SiteProperties siteProperties;
    private final TodoFinder finder;

    public TodoController(SiteProperties siteProperties, TodoFinder finder) {
        this.siteProperties = siteProperties;
        this.finder = finder;
    }

    @ModelAttribute("site")
    public SiteProperties siteProperties() {
        return siteProperties;
    }

    @RequestMapping("/todos")
    public void todos() throws Exception {
    }

    @RequestMapping(value = "/todos", produces = "text/csv")
    public void todosCsv(Model model) throws Exception {
        model.addAttribute("todos", new TodoSpreadsheetConverter().convert(finder.getAll()));
    }

    public static class TodoCsvViewResolver implements ViewResolver {

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
        protected boolean generatesDownloadContent() {
            return true;
        }

        @Override
        protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
            logger.debug("model as csv");

            response.addHeader("Content-Disposition", "attachment; filename=\"todos.csv\"");
            response.getWriter().println("id,title,completed");

            List<Todo> todos = (List<Todo>) model.getOrDefault("todos", Collections.emptyList());
            for (Todo todo : todos) {
                String line = String.format("%d,%s,%s", todo.getId(), todo.getTitle(), todo.isCompleted());
                response.getWriter().println(line);
            }

            response.flushBuffer();
        }
    }
}
