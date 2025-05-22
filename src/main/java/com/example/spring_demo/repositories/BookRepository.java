package com.example.spring_demo.repositories;

import com.example.spring_demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom query methods here if needed
}
