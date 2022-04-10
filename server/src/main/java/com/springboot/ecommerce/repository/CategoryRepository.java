package com.springboot.ecommerce.repository;

import java.util.Optional;

import com.springboot.ecommerce.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findBySlug(String slug);
}
