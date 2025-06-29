package com.example.spring_demo.payload;

import lombok.Data;                // Generates getters, setters, toString, equals, and hashCode
import lombok.AllArgsConstructor;  // Generates a constructor with all fields as parameters
import lombok.NoArgsConstructor;   // Generates a no-argument constructor

import java.util.List;

/*
Future-Proofing
Maybe today you're only returning a list of categories, but in the future you might want to include:

Pagination info

A summary count

Server timestamp

Warnings or user messages

With a CategoryResponse, you don’t need to change the controller or client code — you just add new fields to the wrapper class.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private List<CategoryDTO> content;
}
