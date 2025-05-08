package com.example.spring_demo.service;

import com.example.spring_demo.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
