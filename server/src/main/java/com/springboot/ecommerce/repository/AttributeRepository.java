package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Attribute;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {

}
