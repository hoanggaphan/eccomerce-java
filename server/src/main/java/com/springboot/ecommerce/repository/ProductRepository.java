package com.springboot.ecommerce.repository;

import java.util.Optional;

import com.springboot.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Optional<Product> findBySlug(String slug);

  // Page<Product> findByColorContainingIgnoreCase(String color, Pageable
  // pageable);

  // Page<Product> findBySizeContainingIgnoreCase(String size, Pageable pageable);
}
