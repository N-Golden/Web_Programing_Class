package org.example.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;
import org.example.utils.Constant;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/login"})
public class LoginCookie extends HttpServlet {

    private UserService userService = new UserServiceImpl();

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
            isValid = userService.checkExistUsername(username, password);
        }

        if (isValid) {
            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } else {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login.jsp");
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean isValid = false;
        if (!username.isEmpty() && !password.isEmpty()) {
            isValid = userService.checkExistUsername(username, password);
        }

        if (isValid) {
            // create new cookies
            Cookie usernameCookie = new Cookie("username", username);
            Cookie passwordCookie = new Cookie("password", password);
            //set expire date 24h
            usernameCookie.setMaxAge(60 * 60 * 24);
            passwordCookie.setMaxAge(60 * 60 * 24);
            //add both in response header
            resp.addCookie(usernameCookie);
            resp.addCookie(passwordCookie);

            User user = userService.findByUsername(username, password);
            if(user!=null){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
            }

            resp.sendRedirect(req.getContextPath() + "/admin/category/list");
        } else {
            req.setAttribute("alert", "Sai thông tin đăng nhập, thử lại!");
            req.getRequestDispatcher(Constant.Path.LOGIN).forward(req, resp);
        }
    }
}
