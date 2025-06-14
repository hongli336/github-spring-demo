package com.example.spring_demo.controller;
import com.example.spring_demo.model.Category;
import com.example.spring_demo.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController (CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
    Use ResponseEntity to return both the object body and the HTTP status
     */
    //@GetMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories", method= RequestMethod.GET)
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categories= categoryService.getAllCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    /*
    Use ResponseEntity to return both the object body and the HTTP status
    PUT - update existing category
    */
    //@PutMapping("/api/admin/categories/{categoryId}")
    @RequestMapping(value = "/admin/categories/{categoryId}", method= RequestMethod.PUT)
    public ResponseEntity<String> updateCategory(@RequestBody Category category, @PathVariable Long categoryId) {
        Category savedCategory = categoryService.updateCategory(category, categoryId);
        return new ResponseEntity<>("Category with category id: " + categoryId + " updated.", HttpStatus.OK);
    }

    /*
    Use ResponseEntity to return both the status and the HTTP status
    Post - add new category
    */
    //@PostMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories", method= RequestMethod.POST)
    public ResponseEntity<String> createCategory(@Valid @RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("category added successfully", HttpStatus.CREATED);
    }

    /*
     RESTful DELETE,  It:
     Accepts a category ID,
     Delegates deletion to the service layer,
     Returns HTTP 200 on success, or
     Returns a proper HTTP error (e.g., 404 Not Found) using ResponseStatusException.
     */
    //@DeleteMapping("/api/admin/categories/{categoryId}")
    @RequestMapping(value = "/admin/categories/{categoryId}", method= RequestMethod.DELETE)
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        String status = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
