package com.springboot.ecommerce.service.impl;

import java.util.List;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.repository.ProductRepository;
import com.springboot.ecommerce.service.ProductService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProduct(Long id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
  }

  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  public Product updateProduct(Long id, Product product) {
    productRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
    product.setId(id);
    return productRepository.save(product);
  }

  public void deleteProduct(Long id) {
    productRepository.deleteById(id);
  }
}
