package com.example.helloservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/improved-hello"})
public class ImprovedHelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestName = req.getParameter("name");
        String servletName = getServletConfig().getServletName();

        req.setAttribute("requestName", requestName);
        req.setAttribute("servletName", servletName);

        req.getRequestDispatcher("/improved-hello.jsp")
                .forward(req, resp);
    }
}
