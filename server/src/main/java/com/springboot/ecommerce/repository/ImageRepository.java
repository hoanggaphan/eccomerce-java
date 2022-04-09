package com.springboot.ecommerce.repository;

import com.springboot.ecommerce.model.Image;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
