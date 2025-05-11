package com.example.spring_demo.controller;
import com.example.spring_demo.model.Category;
import com.example.spring_demo.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

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
    public ResponseEntity<List<Category>> getAllCategories() {
        try {
            List<Category> categories= categoryService.getAllCategories();
            return new ResponseEntity<>(categories, HttpStatus);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        try {
            categoryService.createCategory(category);
            //return "Category added successfully";
            return new ResponseEntity<>("category added successfully", HttpStatus.CREATED);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    /*
     RESTful DELETE,  It:
     Accepts a category ID,
     Delegates deletion to the service layer,
     Returns HTTP 200 on success, or
     Returns a proper HTTP error (e.g., 404 Not Found) using ResponseStatusException.
     */
    @DeleteMapping("/api/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
            // return ResponseEntity.status(HttpStatus.OK).body(status);
        } catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
