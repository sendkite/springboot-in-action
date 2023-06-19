package com.example.helloservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String reqName = req.getParameter("name");

        String servletName = getServletConfig().getServletName();

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n");
        html.append("<html>\n");
        html.append("<head>\n");
        html.append("<title>Hello Servlet</title>\n");
        html.append("</head>\n");
        html.append("<body>\n");
        html.append("<h1>Hello Servlet</h1>\n");
        html.append("<p>안녕하세요. " + reqName + "님!</p>\n");
        html.append("<p>저는 " + servletName + "입니다.</p>\n");
        html.append("</body>\n");

        res.setStatus(200);
        res.setContentType("text/html; charset=UTF-8");
        res.getWriter().write(html.toString());
    }
}
