package com.example.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
