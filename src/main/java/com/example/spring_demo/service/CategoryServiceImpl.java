package com.example.spring_demo.service;

import com.example.spring_demo.exceptions.APIException;
import com.example.spring_demo.exceptions.ResourceNotFoundException;
import com.example.spring_demo.model.Category;
import com.example.spring_demo.payload.CategoryResponse;
import com.example.spring_demo.repositories.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import com.example.spring_demo.payload.CategoryDTO;

@Service
public class CategoryServiceImpl implements CategoryService {

    //private List<Category> categories = new ArrayList<>();
    //private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    /*
    @Override
    public List<CategoryDTO> getAllCategories(){
        //return categoryRepository.findAll();
        //return categories;
        List<Category> categories = categoryRepository.findAll();

        for (Category category : categories) {
            if (category.getCategoryName() == null) {
                throw new IllegalStateException("Category with null name found. Category ID: " + category.getCategoryId());
            }
        }

        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    */

    public CategoryResponse getAllCategories(){
        //return categoryRepository.findAll();
        //return categories;
        List<Category> categories = categoryRepository.findAll();

        if (categories.isEmpty())
            throw new APIException("No category created till now.");

        List<CategoryDTO> categoryDTOS  = categories.stream()
                .map(category -> modelMapper.map(category, CategoryDTO.class))
                .toList();

        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        return categoryResponse;
    }


    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategoryFromDB = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savedCategoryFromDB != null)
            throw new APIException("Category with the name " + categoryDTO.getCategoryName() + " already exist.");
        //category.setCategoryId(nextId++);
        //categories.add(category);
        Category savedCategory = categoryRepository.save(category);
        CategoryDTO savedCategoryDTO = modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO ;

    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        savedCategory.setCategoryName(categoryDTO.getCategoryName());
        Category updatedCategory = categoryRepository.save(savedCategory);

        return convertToDTO(updatedCategory);

        // Category savedCategory = categoryRepository.findById(categoryId)
        // .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));
        // category.setCategoryId(categoryId);
        // savedCategory = categoryRepository.save(category);
        // return savedCategory;
    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));

        // Category category = categoryRepository.findById(categoryId)
        //        .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found."));

        categoryRepository.delete(savedCategory);
        return "Category with CategoryId: " + categoryId + " deleted.";
    }

    // Helper method to convert Entity to DTO
    private CategoryDTO convertToDTO(Category category) {
        return new CategoryDTO(category.getCategoryId(), category.getCategoryName());
    }

    // Helper method to convert DTO to Entity
    private Category convertToEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setCategoryId(categoryDTO.getCategoryId()); // optional for create
        category.setCategoryName(categoryDTO.getCategoryName());
        return category;
    }
}
