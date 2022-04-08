package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Sku;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SkuRepository extends JpaRepository<Sku, Long> {

}
