package org.example.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.models.User;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginCookie extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //cookie
        String username = "";
        String password = "";
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    username = cookie.getValue();
                }
                if (cookie.getName().equals("password")) {
                    password = cookie.getValue();
                }
            }
        }
        boolean isValid = false;
        if (!username.isEmpty() && !password.isEmpty()) {
            InputStream userData = getClass().getResourceAsStream("/user.json");
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(userData, User.class);
            if(user != null){
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    isValid = true;
                }
            }
        }

        if (isValid) {
            PrintWriter out = resp.getWriter();
            out.println("Hello " + username);
        }else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("Username");
        String password = req.getParameter("Password");
        // create new cookies
        Cookie usernameCookie = new Cookie("username", username);
        Cookie passwordCookie = new Cookie("password", password);
        //set expire date 24h
        usernameCookie.setMaxAge(60 * 60 * 24);
        passwordCookie.setMaxAge(60 * 60 * 24);
        //add both in response header
        resp.addCookie(usernameCookie);
        resp.addCookie(passwordCookie);
    }
}
