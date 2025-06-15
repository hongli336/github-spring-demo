package com.example.spring_demo.payload;

import lombok.Data;                // Generates getters, setters, toString, equals, and hashCode
import lombok.AllArgsConstructor;  // Generates a constructor with all fields as parameters
import lombok.NoArgsConstructor;   // Generates a no-argument constructor

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
