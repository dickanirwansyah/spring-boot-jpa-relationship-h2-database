package com.dicka.examplerelationship.repository;

import com.dicka.examplerelationship.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
