package com.springboot.ecommerce.service.impl;

import java.util.List;
import java.util.Optional;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.repository.ProductRepository;
import com.springboot.ecommerce.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
  private final ProductRepository productRepository;

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  // Dùng để demo
  public List<Product> getPopularProduct() {
    Page<Product> page = productRepository.findAll(PageRequest.of(0, 9));
    return page.toList();
  }

  public Product getProduct(String slug) {
    Optional<Product> optionalProduct = productRepository.findBySlug(slug);

    if (optionalProduct.isPresent()) {
      return optionalProduct.get();
    } else {
      throw new ResourceNotFoundException("Product", "slug", slug);
    }

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
