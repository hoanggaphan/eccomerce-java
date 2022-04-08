package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
