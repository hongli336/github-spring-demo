package com.example.spring_demo.controller;
import com.example.spring_demo.model.Category;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@RestController
public class CategoryController {

    private List<Category> categories = new ArrayList<>();

    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return categories;
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {

        categories.add(category);
        return "Category added successfully";
    }
}
