package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login/session"})
public class LoginSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        HttpSession session = req.getSession(false);
        if (session != null) {
            if (session.getAttribute("username") != null
                    && session.getAttribute("password") != null) {
                String username = (String) session.getAttribute("username");
                String password = (String) session.getAttribute("password");
                InputStream userData = getClass().getResourceAsStream("/user.json");
                ObjectMapper mapper = new ObjectMapper();
                User user = mapper.readValue(userData, User.class);
                if (user != null) {
                    if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                        PrintWriter out = resp.getWriter();
                        out.println("Hello " + username);
                        return;
                    }
                }
            }
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login_session.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("Username");
        String password = req.getParameter("Password");

        HttpSession session = req.getSession(true);
        session.setAttribute("username", username);
        session.setAttribute("password", password);
        session.setMaxInactiveInterval(60);

        PrintWriter out = resp.getWriter();
        out.println("Login successful! Session ID: " + session.getId());
    }
}
