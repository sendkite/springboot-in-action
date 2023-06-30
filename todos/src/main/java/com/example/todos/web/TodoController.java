package com.example.todos.web;

import com.example.todos.web.model.SiteProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {

    private Environment env;

    public TodoController(Environment env) {
        this.env = env;
    }

    @RequestMapping("/todos")
    public ModelAndView todos() throws Exception {

        SiteProperties site = new SiteProperties();
        site.setAuthor(env.getProperty("site.author"));
        site.setDescription(env.getProperty("site.description"));

        ModelAndView mav = new ModelAndView();
        mav.addObject("site", site);
        mav.setViewName("todos");

        return mav;
    }
}
