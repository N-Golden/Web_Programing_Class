package org.example.service;

import jakarta.servlet.http.Part;
import org.example.DAO.CategoryDao;
import org.example.DAO.CategoryDaoImpl;
import org.example.model.Category;
import org.example.utils.Aws;
import org.example.utils.Constant;

import java.io.IOException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    private Aws aws = new Aws();

    @Override
    public void insert(String name, Part image) throws IOException {
        Category category = new Category();
        category.setName(name);
        if (image != null) {
            if (image.getContentType().equals("image/jpeg") ||
                    image.getContentType().equals("image/png")) {
                category.setIcon(getFileName(image));
                aws.uploadFile(getFileName(image), image);
            }
        }
        categoryDao.insert(category);
    }

    @Override
    public void edit(String cateId, String newName, Part filePart) throws IOException {
        Category oldCate = categoryDao.getById(Integer.parseInt(cateId));
        oldCate.setName(newName);
        if (filePart != null) {
            if (filePart.getContentType().equals("image/jpeg") ||
                    filePart.getContentType().equals("image/png")) {
                String fileName = getFileName(filePart);
                aws.uploadFile(fileName, filePart);

                oldCate.setIcon(fileName);
            }
        }
        categoryDao.edit(oldCate);
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return Constant.DEFAULT_FILENAME;
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        Aws aws = new Aws();
        Category category = categoryDao.getById(id);
        category.setIcon(aws.generatePresignedGetUrl(category.getIcon()));
        return category;
    }

    @Override
    public Category get(String name) {
        return categoryDao.get(name);
    }

    @Override
    public List<Category> getAll() {
        Aws aws = new Aws();
        List<Category> categories = categoryDao.getAll();
        for (Category category : categories) {
            String icon = category.getIcon();
            String newIcon = aws.generatePresignedGetUrl(icon);
            category.setIcon(newIcon);
        }
        return categories;
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}
