package org.example.service;

import jakarta.servlet.http.Part;
import org.example.model.Category;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    void insert(String name, Part image) throws IOException;
    void edit(String cateId, String newName, Part filePart) throws IOException;
    void delete(int id);
    Category get(int id);
    Category get(String name);
    List<Category> getAll();
    List<Category> search(String keyword);
}
