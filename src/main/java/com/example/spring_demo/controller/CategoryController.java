package com.example.spring_demo.controller;
import com.example.spring_demo.model.Category;
import com.example.spring_demo.payload.CategoryDTO;
import com.example.spring_demo.payload.CategoryResponse;
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
    public ResponseEntity<CategoryResponse> getAllCategories() {
        CategoryResponse categoryResponse = categoryService.getAllCategories();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    /*
    Use ResponseEntity to return both the object body and the HTTP status
    PUT - update existing category
    */
    //@PutMapping("/api/admin/categories/{categoryId}")
    @RequestMapping(value = "/admin/categories/{categoryId}", method= RequestMethod.PUT)
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }

    /*
    Use ResponseEntity to return both the status and the HTTP status
    Post - add new category
    @PostMapping("/categories"): Handles POST requests to create a new category.

    @RequestBody CategoryDTO categoryDTO:
    Spring automatically deserializes the JSON body of the request into a CategoryDTO object.
    This requires that the incoming JSON matches the fields in CategoryDTO.
    */

    //@PostMapping("/api/public/categories")
    @RequestMapping(value = "/public/categories", method= RequestMethod.POST)
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        CategoryDTO savedCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.CREATED);
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
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long categoryId) {
        CategoryDTO savedCategoryDTO = categoryService.deleteCategory(categoryId);
        return new ResponseEntity<>(savedCategoryDTO, HttpStatus.OK);
    }
}
