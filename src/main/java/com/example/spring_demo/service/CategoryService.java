package com.example.spring_demo.service;

import com.example.spring_demo.model.Category;
import com.example.spring_demo.payload.CategoryDTO;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategories();
    void createCategory(CategoryDTO categoryDTO);
    Category updateCategory(CategoryDTO categoryDTO, Long categoryId);
    String deleteCategory(Long categoryId);
}
