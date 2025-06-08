package com.example.spring_demo.exceptions;

public class InvalidCategoryException extends RuntimeException  {

    public InvalidCategoryException(String message) {
        super(message);
    }
}
