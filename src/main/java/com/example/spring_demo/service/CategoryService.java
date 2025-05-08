package com.example.spring_demo.service;

import com.example.spring_demo.model.Category;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
}
