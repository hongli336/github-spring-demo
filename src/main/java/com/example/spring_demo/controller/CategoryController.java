package com.example.spring_demo.controller;
import com.example.spring_demo.model.Category;
import com.example.spring_demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@RestController
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {

        categoryService.createCategory(category);
        return "Category added successfully";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return status;
    }
}
