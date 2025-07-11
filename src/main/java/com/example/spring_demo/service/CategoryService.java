package com.example.spring_demo.service;

import com.example.spring_demo.model.Category;
import com.example.spring_demo.payload.CategoryDTO;
import com.example.spring_demo.payload.CategoryResponse;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber, Integer pageSize, String sortBy, String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId);
    CategoryDTO deleteCategory(Long categoryId);
}
