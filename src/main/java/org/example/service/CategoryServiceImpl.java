package org.example.service;

import org.example.DAO.CategoryDao;
import org.example.DAO.CategoryDaoImpl;
import org.example.model.Category;
import org.example.utils.Aws;

import java.io.File;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public void insert(Category category) {
        categoryDao.insert(category);
    }

    @Override
    public void edit(Category newCategory) {
        Category oldCate = categoryDao.get(newCategory.getId());
        oldCate.setName(newCategory.getName());

        if (newCategory.getIcon() != null) {
            String fileName = oldCate.getIcon();
            final String dir = "E:\\upload";
            File file = new File(dir + "/category" + fileName);
            if (file.exists()) {
                file.delete();
            }
            oldCate.setIcon(newCategory.getIcon());
        }
        categoryDao.edit(oldCate);
    }

    @Override
    public void delete(int id) {
        categoryDao.delete(id);
    }

    @Override
    public Category get(int id) {
        Aws aws = new Aws();
        Category category = categoryDao.get(id);
        category.setIcon(aws.getImageCategoryLink(category.getIcon()));
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
            String newIcon = aws.getImageCategoryLink(icon);
            category.setIcon(newIcon);
        }
        return categories;
    }

    @Override
    public List<Category> search(String keyword) {
        return categoryDao.search(keyword);
    }
}
