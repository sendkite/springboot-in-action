package com.example.todos.web;

import com.example.todos.web.model.SiteProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    private final SiteProperties siteProperties;

    public TodoController(SiteProperties siteProperties) {
        this.siteProperties = siteProperties;
    }

    @RequestMapping("/todos")
    public ModelAndView todos() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("site", siteProperties);
        mav.setViewName("todos");

        return mav;
    }
}
