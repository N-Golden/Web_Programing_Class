package org.example.controllers;

import com.mysql.cj.Constants;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.example.model.Category;
import org.example.service.CategoryService;
import org.example.service.CategoryServiceImpl;
import org.example.utils.Constant;

import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/admin/category/edit"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CategoryEditController extends HttpServlet {
    CategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Category category = cateService.get(Integer.parseInt(id));
        req.setAttribute("category", category);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit-category.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse
            resp) throws ServletException, IOException {

        // Lấy file từ form (input name="file")
        Part filePart = req.getPart("icon");
        String id = req.getParameter("cate_id");
        String name = req.getParameter("name");

        cateService.edit(id, name, filePart);
        resp.sendRedirect(req.getContextPath() + "/admin/category/list");
    }
}