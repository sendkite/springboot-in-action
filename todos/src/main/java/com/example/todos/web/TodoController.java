package com.example.todos.web;

import com.example.todos.web.model.SiteProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TodoController {

    private final SiteProperties siteProperties;

    public TodoController(SiteProperties siteProperties) {
        this.siteProperties = siteProperties;
    }

    @RequestMapping("/todos")
    public String todos(Model model) throws Exception {
        model.addAttribute("site", siteProperties);
        return "todos";
    }
}
