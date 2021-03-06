package com.springboot.ecommerce.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.springboot.ecommerce.exception.ResourceNotFoundException;
import com.springboot.ecommerce.model.Category;
import com.springboot.ecommerce.model.Product;
import com.springboot.ecommerce.repository.CategoryRepository;
import com.springboot.ecommerce.service.CategoryService;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryImpl implements CategoryService {
  private final CategoryRepository categoryRepository;

  public List<Category> getAllCategories() {
    return categoryRepository.findAll();
  }

  public Category getCategory(Long id) {
    return categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category", "Id", id));
  }

  public Collection<Product> getCategoryProducts(String slug) {
    Optional<Category> optionalCategory = categoryRepository.findBySlug(slug);

    if (optionalCategory.isPresent()) {
      return optionalCategory.get().getProducts();
    } else {
      throw new ResourceNotFoundException("Category", "slug", slug);
    }
  }

  public Category createCategory(Category category) {
    return categoryRepository.save(category);
  }

  public Category updateCategory(Long id, Category category) {
    categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
    category.setId(id);
    return categoryRepository.save(category);
  }

  public void deleteCategory(Long id) {
    categoryRepository.deleteById(id);
  }
}
